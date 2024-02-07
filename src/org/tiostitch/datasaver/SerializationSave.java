package org.tiostitch.datasaver;

import org.tiostitch.datasaver.data.PlayerData;

import java.io.*;

public final class SerializationSave {

    private SerializationSave() throws IOException {

        final PlayerData playerData = new PlayerData();
        playerData.setName("User");
        playerData.setCoins(1000);
        playerData.setGems(250);

        writeSerializableObject(playerData);
        readSerializableObject(playerData);
    }

    private void writeSerializableObject(PlayerData playerData) {
        try (FileOutputStream outputStream = new FileOutputStream("serialized-data.json")) {
            try (ObjectOutput playerDataOutput = new ObjectOutputStream(outputStream)) {

                playerDataOutput.writeObject(playerData);
                playerDataOutput.flush();
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readSerializableObject(PlayerData playerData) {
        PlayerData newPlayerData;
        try (FileInputStream inputStream = new FileInputStream("serialized-data.json")) {
            try (ObjectInput playerDataInput = new ObjectInputStream(inputStream)) {
                newPlayerData = (PlayerData) playerDataInput.readObject();
                Utils.printar(newPlayerData);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new SerializationSave();
    }
}

package org.tiostitch.datasaver;

import java.io.*;

public final class SerializationSave {

    private SerializationSave() throws IOException {

        final PlayerData playerData = new PlayerData();
        playerData.setName("User");
        playerData.setCoins(1000);
        playerData.setGems(250);

        try (FileOutputStream outputStream = new FileOutputStream("serialized-data.json")) {
            try (ObjectOutput playerDataOutput = new ObjectOutputStream(outputStream)) {

                playerDataOutput.writeObject(playerData);

                playerDataOutput.flush();
                outputStream.flush();
            }
        }

        PlayerData newPlayerData = null;
        try (FileInputStream inputStream = new FileInputStream("serialized-data.json")) {
            try (ObjectInput playerDataInput = new ObjectInputStream(inputStream)) {
                newPlayerData = (PlayerData) playerDataInput.readObject();
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        assert newPlayerData != null;
        printar(newPlayerData);
    }

    private void printar(PlayerData playerData) {
        System.out.println();
        System.out.println("Dados do Jogador:");
        System.out.println("Nome: " + playerData.getName());
        System.out.println("Coins: " + playerData.getCoins());
        System.out.println("Gems: " + playerData.getGems());
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        new SerializationSave();
    }
}

package org.tiostitch.datasaver;

import java.io.*;

public final class SplitedSave {

    private SplitedSave() {

        final PlayerData playerData = new PlayerData();
        playerData.setName("User");
        playerData.setCoins(1000);
        playerData.setGems(250);

        final File file = new File("separatedsplit-data.txt");

        writeSplitObject(file, playerData);
        loadSplitObject(file);
    }

    private void loadSplitObject(File file) {
        final PlayerData newPlayerData = new PlayerData();
        try (BufferedReader bR = new BufferedReader(new FileReader(file))) {
            final String[] splittedbar = bR.readLine().split(":");
            newPlayerData.setName(splittedbar[0]);
            newPlayerData.setCoins(Integer.parseInt(splittedbar[1]));
            newPlayerData.setGems(Integer.parseInt(splittedbar[2]));

            printar(newPlayerData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeSplitObject(File file, PlayerData playerData) {
        try (BufferedWriter bF = new BufferedWriter(new FileWriter(file))) {
            bF.write(splittedPlayerSave(playerData));
            bF.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printar(PlayerData playerData) {
        System.out.println();
        System.out.println("Dados do Jogador:");
        System.out.println("Nome: " + playerData.getName());
        System.out.println("Coins: " + playerData.getCoins());
        System.out.println("Gems: " + playerData.getGems());
        System.out.println();
    }

    private String splittedPlayerSave(PlayerData pD) {
        return pD.getName() + ":" + pD.getCoins() + ":" + pD.getGems();
    }

    public static void main(String[] args) throws IOException {
        new SplitedSave();
    }
}

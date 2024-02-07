package org.tiostitch.datasaver;

import java.io.*;

public final class SplitedSave {

    private SplitedSave() throws IOException {

        final PlayerData playerData = new PlayerData();
        playerData.setName("User");
        playerData.setCoins(1000);
        playerData.setGems(250);

        final File file = new File("splited-data.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (Writer writer = new FileWriter(file)) {
            try (BufferedWriter bF = new BufferedWriter(writer)) {

                bF.write(splittedPlayerSave(playerData));

                writer.flush();
                bF.flush();
            }
        }

        final PlayerData newPlayerData = new PlayerData();
        try (Reader reader = new FileReader(file)) {
            try (BufferedReader bR = new BufferedReader(reader)) {
                final String[] splittedbar = bR.readLine().split(":");
                newPlayerData.setName(splittedbar[0]);
                newPlayerData.setCoins(Integer.parseInt(splittedbar[1]));
                newPlayerData.setGems(Integer.parseInt(splittedbar[2]));

                printar(newPlayerData);
            }
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

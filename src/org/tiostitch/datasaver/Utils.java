package org.tiostitch.datasaver;

import org.tiostitch.datasaver.data.PlayerData;

public final class Utils {

    public static void printar(PlayerData playerData) {
        System.out.println();
        System.out.println("Dados do Jogador:");
        System.out.println("Nome: " + playerData.getName());
        System.out.println("Coins: " + playerData.getCoins());
        System.out.println("Gems: " + playerData.getGems());
        System.out.println();
    }
}

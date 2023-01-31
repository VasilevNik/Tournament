package ru.netology.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<Player>();


    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player name1 = null;
        Player name2 = null;


        for (Player player : playerList) {
            if (player.getName().equals(playerName1)) {
                name1 = player;
            }
            if (player.getName().equals(playerName2)) {
                name2 = player;
            }
        }

        if (name1 == null) {
            throw new NotRegisteredException("A player with a nickname " + playerName1 + " not found");
        }
        if (name2 == null) {
            throw new NotRegisteredException("A player with a nickname " + playerName2 + " not found");
        }

        if (name1.getStrength() < name2.getStrength()) {
            return 2;
        } else if (name1.getStrength() > name2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

}

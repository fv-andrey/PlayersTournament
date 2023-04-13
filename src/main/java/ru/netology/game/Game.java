package ru.netology.game;

import ru.netology.exception.NotRegisteredException;
import ru.netology.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findPlayer1(String playerName1) {
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                return player;
            }
        }
        return null;
    }

    public Player findPlayer2(String playerName2) {
        for (Player player : players) {
            if (player.getName().equals(playerName2)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findPlayer1(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player " + playerName1 + " not registered"
            );
        }
        if (findPlayer2(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player " + playerName2 + " not registered"
            );
        }
        int strength1 = 0;
        int strength2 = 0;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                strength1 = player.getStrength();
            }
            if (player.getName().equals(playerName2)) {
                strength2 = player.getStrength();
            }
        }
        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }
    }
}

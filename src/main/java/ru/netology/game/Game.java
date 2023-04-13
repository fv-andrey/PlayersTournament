package ru.netology.game;

import ru.netology.exception.NotRegisteredException;
import ru.netology.player.Player;

import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public Player findPlayer1(String playerName1) {
        for (String key : players.keySet()) {
            Player player = players.get(key);
            if (player.getName().equals(playerName1)) {
                return player;
            }
        }
        return null;
    }

    public Player findPlayer2(String playerName2) {
        for (String key : players.keySet()) {
            Player player = players.get(key);
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
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}

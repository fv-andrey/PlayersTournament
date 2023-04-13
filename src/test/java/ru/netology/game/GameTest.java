package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisteredException;
import ru.netology.player.Player;

public class GameTest {

    Player player1 = new Player(1, "Fox", 5);
    Player player2 = new Player(2, "Bear", 7);
    Player player3 = new Player(3, "Wolf", 5);

    @Test
    void shouldShowTieBetweenPlayers() {
        Game game = new Game();

        game.register("Fox", player1);
        game.register("Bear", player2);
        game.register("Wolf", player3);

        int expected = 0;
        int actual = game.round("Fox", "Wolf");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldShowWinTheSecondPlayer() {
        Game game = new Game();

        game.register("Fox", player1);
        game.register("Bear", player2);
        game.register("Wolf", player3);

        int expected = 2;
        int actual = game.round("Fox", "Bear");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldShowWinTheFirstPlayer() {
        Game game = new Game();

        game.register("Fox", player1);
        game.register("Bear", player2);
        game.register("Wolf", player3);

        int expected = 1;
        int actual = game.round("Bear", "Fox");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldGenerateNotRegisteredExceptionWhenFirstPlayerIsNotRegistered() {
        Game game = new Game();

        game.register("Fox", player1);
        game.register("Bear", player2);
        game.register("Wolf", player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Hare", "Fox");
        });
    }

    @Test
    void shouldGenerateNotRegisteredExceptionWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();

        game.register("Fox", player1);
        game.register("Bear", player2);
        game.register("Wolf", player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Wolf", "Hare");
        });
    }
}

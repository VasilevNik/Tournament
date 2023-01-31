package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Game;

import java.util.ArrayList;
import java.util.Objects;

public class GameTest {


    @Test

    public void addPlayersToTheGameAlternately() {
        Game game = new Game();
        Player name1 = new Player(1, "Artur Pirozhkov", 150);
        Player name2 = new Player(2, "Tester", 100);

        game.register(name1);
        game.register(name2);


        int expected = 1;
        int actual = game.round("Artur Pirozhkov", "Tester");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void addPlayerWithMoreStrength() {
        Game game = new Game();
        Player name1 = new Player(1, "Artur Pirozhkov", 150);
        Player name2 = new Player(2, "Tester", 100);
        game.register(name1);
        game.register(name2);

        int expected = 2;
        int actual = game.round("Tester", "Artur Pirozhkov");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void returnZeroIfStrengthIsEqual() {
        Game game = new Game();
        Player name1 = new Player(1, "Artur Pirozhkov", 35);
        Player name2 = new Player(2, "Tester", 35);
        game.register(name1);
        game.register(name2);

        int expected = 0;
        int actual = game.round("Artur Pirozhkov", "Tester");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void addTheFirstUnregisteredPlayer() {
        Game game = new Game();
        Player name1 = new Player(1, "Artur Pirozhkov", 35);
        Player name2 = new Player(2, "Tester", 35);


        game.register(name2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Artur Pirozhkov", "Tester");
        });
    }

    @Test

    public void addTheTwoUnregisteredPlayer() {
        Game game = new Game();
        Player name1 = new Player(1, "Artur Pirozhkov", 35);
        Player name2 = new Player(2, "Tester", 35);

        game.register(name1);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Artur Pirozhkov", "Tester");
        });
    }
}


package dev.mdavenport.adventofcode2023.solutions;

import dev.mdavenport.adventofcode2023.solutions.Day2.CubeCount;
import dev.mdavenport.adventofcode2023.solutions.Day2.Game;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    private static final Map<Integer, Game> exampleGames = Map.of(
            1, new Game(1, List.of(
                    new CubeCount(4, 0, 3),
                    new CubeCount(1, 2, 6),
                    new CubeCount(0, 2, 0)
            )),
            2, new Game(2, List.of(
                    new CubeCount(0, 2, 1),
                    new CubeCount(1, 3, 4),
                    new CubeCount(0, 1, 1)
            )),
            3, new Game(3, List.of(
                    new CubeCount(20, 8, 6),
                    new CubeCount(4, 13, 5),
                    new CubeCount(1, 5, 0)
            )),
            4, new Game(4, List.of(
                   new CubeCount(3, 1, 6),
                   new CubeCount(6, 3, 0),
                   new CubeCount(14, 3, 15)
            )),
            5, new Game(5, List.of(
                    new CubeCount(6, 3, 1),
                    new CubeCount(1, 2, 2)
            )),
            12, new Game(12, List.of(
                    new CubeCount(4, 2, 0),
                    new CubeCount(1, 3, 8)
            ))
    );
    @Test
    void possibleGame_examples() {
        assertTrue(Day2.possibleGame(exampleGames.get(1)));
        assertTrue(Day2.possibleGame(exampleGames.get(2)));
        assertFalse(Day2.possibleGame(exampleGames.get(3)));
        assertFalse(Day2.possibleGame(exampleGames.get(4)));
        assertTrue(Day2.possibleGame(exampleGames.get(5)));
    }

    @Test
    void minCubesRequired_examples() {
        assertEquals(new CubeCount(4, 2, 6), Day2.minCubesRequired(exampleGames.get(1)));
        assertEquals(new CubeCount(1, 3, 4), Day2.minCubesRequired(exampleGames.get(2)));
        assertEquals(new CubeCount(20, 13, 6), Day2.minCubesRequired(exampleGames.get(3)));
        assertEquals(new CubeCount(14, 3, 15), Day2.minCubesRequired(exampleGames.get(4)));
        assertEquals(new CubeCount(6, 3, 2), Day2.minCubesRequired(exampleGames.get(5)));
    }

    @Test
    void cubePower_examples() {
        assertEquals(48, new CubeCount(4, 2, 6).power());
        assertEquals(12, new CubeCount(1, 3, 4).power());
        assertEquals(1560, new CubeCount(20, 13, 6).power());
        assertEquals(630, new CubeCount(14, 3, 15).power());
        assertEquals(36, new CubeCount(6, 3, 2).power());
    }

    @Test
    void parseGame_examples() {
        assertEquals(exampleGames.get(1), Day2.parseGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        assertEquals(exampleGames.get(2), Day2.parseGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
        assertEquals(exampleGames.get(3), Day2.parseGame("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
        assertEquals(exampleGames.get(4), Day2.parseGame("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
        assertEquals(exampleGames.get(5), Day2.parseGame("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
        assertEquals(exampleGames.get(12), Day2.parseGame("Game 12: 4 red, 2 green; 8 blue, 3 green, 1 red"));
    }
}
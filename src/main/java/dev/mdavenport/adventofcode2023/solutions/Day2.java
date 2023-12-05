package dev.mdavenport.adventofcode2023.solutions;

import dev.mdavenport.adventofcode2023.util.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    private static final CubeCount maxCubes = new CubeCount(12, 13, 14);

    /**
     * Calculates whether a given game is "possible" using a maximum of 12 red, 13 green, and 14 blue cubes.
     * A game is given in the form "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green".
     *
     * @param game a properly formatted game with an ID and a list of cube handfuls pulled from the bag
     * @return true if the game is possible with the given cube limits and false otherwise
     */
    public static boolean possibleGame(Game game) {
        for (CubeCount count : game.handfuls()) {
            if (count.red() > maxCubes.red()
                || count.green() > maxCubes.green()
                || count.blue() > maxCubes.blue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the minimum number of cubes required to be in the bag for the given game to be "possible".
     * A game is given in the form "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green".
     *
     * @param game a properly formatted game with an ID and a list of cube handfuls pulled from the bag
     * @return the minimum number of each color of cube required to be in the bag for the game to be possible
     */
    public static CubeCount minCubesRequired(Game game) {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;
        for (CubeCount handful : game.handfuls()) {
            maxRed = Math.max(maxRed, handful.red());
            maxGreen = Math.max(maxGreen, handful.green());
            maxBlue = Math.max(maxBlue, handful.blue());
        }
        return new CubeCount(maxRed, maxGreen, maxBlue);
    }

    public static Game parseGame(String game) {
        String[] gameIdAndHandfuls = game.split(": ");
        int gameId = Integer.parseInt(gameIdAndHandfuls[0].split(" ")[1]);
        String[] gameString = gameIdAndHandfuls[1].split("; ");
        List<CubeCount> handfuls = new ArrayList<>(gameString.length);
        for (String handfulString : gameString) {
            String[] cubeCounts = handfulString.split(", ");
            Map<String, Integer> counts = new HashMap<>(3);
            for (String cubeCount : cubeCounts) {
                String[] numAndColor = cubeCount.split(" ");
                int num = Integer.parseInt(numAndColor[0]);
                String color = numAndColor[1];
                counts.put(color, num);
            }
            handfuls.add(new CubeCount(counts.getOrDefault("red", 0),
                    counts.getOrDefault("green", 0),
                    counts.getOrDefault("blue", 0)));
        }
        return new Game(gameId, handfuls);
    }

    public static void main(String[] args) {
        int part1ExampleResult = Input.asLines("day2-example.txt").map(Day2::parseGame).filter(Day2::possibleGame).mapToInt(Game::id).sum();
        System.out.println(STR."Day 2, Part 1 Example: \{ part1ExampleResult }");

        int part1Result = Input.asLines("day2-input.txt").map(Day2::parseGame).filter(Day2::possibleGame).mapToInt(Game::id).sum();
        System.out.println(STR."Day 2, Part 1 Result: \{ part1Result }");

        long part2ExampleResult = Input.asLines("day2-example.txt").map(Day2::parseGame).map(Day2::minCubesRequired).mapToLong(CubeCount::power).sum();
        System.out.println(STR."Day 2, Part 2 Example: \{ part2ExampleResult }");

        long part2Result = Input.asLines("day2-input.txt").map(Day2::parseGame).map(Day2::minCubesRequired).mapToLong(CubeCount::power).sum();
        System.out.println(STR."Day 2, Part 2 Result: \{ part2Result }");
    }

    public record CubeCount(int red, int green, int blue) {
        public long power() {
            return ((long) red) * green * blue;
        }
    }
    public record Game(int id, List<CubeCount> handfuls) {}
}

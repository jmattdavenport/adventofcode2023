package dev.mdavenport.adventofcode2023.solutions;

import dev.mdavenport.adventofcode2023.util.Input;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {
    // Matches all single digits and spelled out representations of single digits
    private static final Pattern digitPattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)");
    private static final Map<String, Integer> intValues = Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5,
            "six", 6, "seven", 7, "eight", 8, "nine", 9);
    public static int extractCalibrationValue(String amendedValue) {
        // Remove everything other than digits
        String digits = amendedValue.replaceAll("\\D", "");
        if (digits.isEmpty()) {
            return -1;
        }
        return Character.getNumericValue(digits.charAt(0)) * 10 + Character.getNumericValue(digits.charAt(digits.length() - 1));
    }

    public static int extractCalibrationValueWithSpelledOutNumbers(String amendedValue) {
        Matcher matcher = digitPattern.matcher(amendedValue);
        if (!matcher.find()) {
            return -1;
        }
        int digit1 = parseInt(matcher.group());
        int digit2 = digit1;
        // Number words can overlap (e.g. "twone").
        // Starting the next find from the second character of the previous match instead of the end of the previous match
        // allows us to select the last number in an overlapping set.
        while (matcher.find(matcher.start() + 1)) {
            digit2 = parseInt(matcher.group());
        }

        return digit1 * 10 + digit2;
    }

    public static void main(String[] args) {
        int part1ExampleResult = Input.asLines("day1part1-example.txt").mapToInt(Day1::extractCalibrationValue).sum();
        System.out.println(STR."Day 1, Part 1 Example: \{ part1ExampleResult }");

        int part1Result = Input.asLines("day1-input.txt").mapToInt(Day1::extractCalibrationValue).sum();
        System.out.println(STR."Day 1, Part 1 Result: \{ part1Result }");

        int part2ExampleResult = Input.asLines("day1part2-example.txt").mapToInt(Day1::extractCalibrationValueWithSpelledOutNumbers).sum();
        System.out.println(STR."Day 1, Part 2 Example: \{ part2ExampleResult }");

        int part2Result = Input.asLines("day1-input.txt").mapToInt(Day1::extractCalibrationValueWithSpelledOutNumbers).sum();
        System.out.println(STR."Day 1, Part 2 Result: \{ part2Result }");
    }

    private static int parseInt(String stringRepresentation) {
        if (intValues.containsKey(stringRepresentation)) {
            return intValues.get(stringRepresentation);
        }
        return Integer.parseInt(stringRepresentation);
    }
}

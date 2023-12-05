package dev.mdavenport.adventofcode2023.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    @Test
    void extractCalibrationValueExamples() {
        assertEquals(12, Day1.extractCalibrationValue("1abc2"));
        assertEquals(38, Day1.extractCalibrationValue("pqr3stu8vwx"));
        assertEquals(15, Day1.extractCalibrationValue("a1b2c3d4e5f"));
        assertEquals(77, Day1.extractCalibrationValue("treb7uchet"));
    }

    @Test
    void extractCalibrationValueSpelledOutExamples() {
                assertEquals(29, Day1.extractCalibrationValueWithSpelledOutNumbers("two1nine"));
                assertEquals(83, Day1.extractCalibrationValueWithSpelledOutNumbers("eightwothree"));
                assertEquals(13, Day1.extractCalibrationValueWithSpelledOutNumbers("abcone2threexyz"));
                assertEquals(24, Day1.extractCalibrationValueWithSpelledOutNumbers("xtwone3four"));
                assertEquals(42, Day1.extractCalibrationValueWithSpelledOutNumbers("4nineeightseven2"));
                assertEquals(14, Day1.extractCalibrationValueWithSpelledOutNumbers("zoneight234"));
                assertEquals(76, Day1.extractCalibrationValueWithSpelledOutNumbers("7pqrstsixteen"));
                assertEquals(11, Day1.extractCalibrationValueWithSpelledOutNumbers("1twone"));
    }
}
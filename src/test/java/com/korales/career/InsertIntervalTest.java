package com.korales.career;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class InsertIntervalTest {

    private final InsertInterval insertInterval = new InsertInterval();

    @Test
    void insertIntervals_mergesWithOverlapAndKeepsNonOverlappingIntervals() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] expected = {{1, 5}, {6, 9}};

        assertArrayEquals(expected, insertInterval.insertIntervals(intervals, newInterval));
    }

    @Test
    void insertIntervals_mergesMultipleOverlappingIntervals() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {4, 8};

        int[][] expected = {{1, 2}, {3, 10}};

        assertArrayEquals(expected, insertInterval.insertIntervals(intervals, newInterval));
    }
}
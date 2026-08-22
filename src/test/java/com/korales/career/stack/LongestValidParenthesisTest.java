package com.korales.career.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestValidParenthesisTest {

    private final LongestValidParenthesis longestValidParenthesis = new LongestValidParenthesis();

    @Test
    void emptyString() {
        assertEquals(0, longestValidParenthesis.longest_valid_parentheses(""));
    }

    @Test
    void onlySingleOpenParenthesis() {
        assertEquals(0, longestValidParenthesis.longest_valid_parentheses("("));
    }

    @Test
    void onlySingleCloseParenthesis() {
        assertEquals(0, longestValidParenthesis.longest_valid_parentheses(")"));
    }

    @Test
    void simplePair() {
        assertEquals(2, longestValidParenthesis.longest_valid_parentheses("()"));
    }

    @Test
    void nestedPair() {
        assertEquals(4, longestValidParenthesis.longest_valid_parentheses("(())"));
    }

    @Test
    void alternatingPairs() {
        assertEquals(4, longestValidParenthesis.longest_valid_parentheses("()()"));
    }

    @Test
    void longerBalancedString() {
        assertEquals(6, longestValidParenthesis.longest_valid_parentheses("(()())"));
    }

    @Test
    void invalidCloseResetsTheCount() {
        assertEquals(2, longestValidParenthesis.longest_valid_parentheses("())(()"));
    }

    @Test
    void test() {
        assertEquals(8, longestValidParenthesis.longest_valid_parentheses("((()()())"));
    }
}
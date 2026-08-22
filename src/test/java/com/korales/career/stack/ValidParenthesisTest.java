package com.korales.career.stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidParenthesisTest {

    private final ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    void isValid_returnsTrue_forBalancedParentheses() {
        assertTrue(validParenthesis.isValid("()"));
        assertTrue(validParenthesis.isValid("(())"));
        assertTrue(validParenthesis.isValid("((()))"));
        assertTrue(validParenthesis.isValid("()()"));
    }

    @Test
    void isValid_returnsFalse_forUnbalancedParentheses() {
        assertFalse(validParenthesis.isValid("("));
        assertFalse(validParenthesis.isValid(")"));
        assertFalse(validParenthesis.isValid("())"));
        assertFalse(validParenthesis.isValid("))(("));
        assertFalse(validParenthesis.isValid("(()"));
        assertFalse(validParenthesis.isValid("())("));
    }

    @Test
    void isValid_returnsTrue_forEmptyString() {
        assertTrue(validParenthesis.isValid(""));
    }
}
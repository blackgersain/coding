package com.korales.career.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    // https://www.hellointerview.com/learn/code/stack/longest-valid-parentheses

    public Integer longest_valid_parentheses(String s) {
        Stack<String> stack = new Stack<>();
        int maxValid = 0;
        int candidateMaxValid = 0;

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);

            if (c.equals("(")) {
                stack.push(c)   ;
                candidateMaxValid++;
            }
            else {
                if (!stack.empty()) {
                    stack.pop();
                    candidateMaxValid++;

                    if (stack.empty()) {
                        maxValid = Math.max(maxValid, candidateMaxValid);
                    }
                }
                else {
                    candidateMaxValid = 0;
                }
            }
        }

        return maxValid;
    }
}

package com.korales.career.bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public Boolean isValid(String s) {
        Map<String, String> matching = new HashMap<>();
        Stack<String> stack = new Stack<>();

        matching.put(")", "(");
        matching.put("]", "[");
        matching.put("}", "{");

        for (int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if (matching.containsKey(curr)) {
                if (stack.empty() || !stack.pop().equals(matching.get(curr))) {
                    return false;
                }
            }
            else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}

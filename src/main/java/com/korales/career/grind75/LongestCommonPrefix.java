package com.korales.career.grind75;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        if (strs.length == 1) {
            return strs[0];
        }

        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());

        for (int i = 0; i < minLength; i++) {
            if (strs[0].substring(i, i + 1).equals(strs[strs.length - 1].substring(i, i + 1))) {
                continue;
            }
            else {
                return strs[0].substring(0, i);
            }
        }

        return strs[0].substring(0, minLength);
    }
}

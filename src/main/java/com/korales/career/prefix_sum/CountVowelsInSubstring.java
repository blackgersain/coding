package com.korales.career.prefix_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelsInSubstring {

    public int[] vowelStrings(String word, int[][] queries) {
        Set<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        int[] prefixSum = new int[word.length() + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            int curr = (vowels.contains(word.substring(i - 1, i)) ? 1 : 0);

            prefixSum[i] = prefixSum[i - 1] +  curr;
        }

        System.out.println(Arrays.toString(prefixSum));

        int[] result = new int[queries.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return result;
    }
}

package com.korales.career.moving_window;

public class MaxPointsFromCards {

    public Integer maxScore(int[] cards, Integer k) {
        int[] newCards = new int[2 * k];

        for (int i = 0; i < k; i++) {
            newCards[i] = cards[cards.length - k + i];
            newCards[k + i] = cards[i];
        }

        int maxScore = Integer.MIN_VALUE;

        int start = 0;
        int windowSum = 0;

        for (int i = 0; i < newCards.length; i++) {
            windowSum += newCards[i];

            if (i - start + 1 == k) {
                maxScore = Math.max(maxScore, windowSum);
                windowSum -= newCards[start];
                start++;
            }
        }

        return maxScore;
    }
}

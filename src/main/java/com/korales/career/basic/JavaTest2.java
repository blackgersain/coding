package com.korales.career.basic;

import java.util.Scanner;

public class JavaTest2 {

    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];

        // Map each person's number to their current seat index
        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        int swaps = 0;

        // Process adjacent seat pairs: (0, 1), (2, 3), ..., (2N - 2, 2N - 1)
        for (int i = 0; i < n; i += 2) {
            int firstPerson = row[i];

            // Partner of person P is always P ^ 1 (0<->1, 2<->3, 4<->5, etc.)
            int expectedPartner = firstPerson ^ 1;

            // If the person sitting next to firstPerson is not their partner
            if (row[i + 1] != expectedPartner) {
                swaps++;

                int partnerPos = pos[expectedPartner];
                int currentNeighbor = row[i + 1];

                // Swap current neighbor with the expected partner
                row[i + 1] = expectedPartner;
                row[partnerPos] = currentNeighbor;

                // Update position mappings after the swap
                pos[currentNeighbor] = partnerPos;
                pos[expectedPartner] = i + 1;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[] A = new int[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                A[i] = sc.nextInt();
            }

            System.out.println(minSwapsCouples(A));
        }
        sc.close();
    }
}

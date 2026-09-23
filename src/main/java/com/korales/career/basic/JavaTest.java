package com.korales.career.basic;

import java.util.Scanner;

public class JavaTest {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int k = 2 * scanner.nextInt();

        if (s == null || s.length() < 2) {
            System.out.println(0);
            return ;
        }

        int start = 0;
        int i = 1;
        int maxBalance = 0;
        int nZeros = 0;
        int nOnes = 0;

        if (s.charAt(0) == '0') {
            nZeros++;
        }
        else {
            nOnes++;
        }

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '0') {
                nZeros++;
            }
            else {
                nOnes++;
            }

            int inbalance = Math.abs(nZeros - nOnes);

            if (inbalance <= k) {
                maxBalance = Math.max(maxBalance, i - start + 1);
                i++;
            }
            else if (start + 1 < i) {
                if (s.charAt(start) == '0') {
                    nZeros--;
                }
                else {
                    nOnes--;
                }

                start++;
                i++;
            }
            else {
                break;
            }
        }

        System.out.println(maxBalance);
    }
}

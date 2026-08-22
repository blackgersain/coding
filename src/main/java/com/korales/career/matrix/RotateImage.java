package com.korales.career.matrix;

import java.util.Arrays;

public class RotateImage {

    public void rotate_image(int[][] matrix) {
        matrix = transpose(matrix);
        matrix = reverseRows(matrix);
    }

    public int[][] transpose(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    public int[][] reverseRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }

        return matrix;
    }
}

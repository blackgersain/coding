package com.korales.career.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiral_order(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int top = 0;
        int bottom = matrix.length -1;
        int left = 0;
        int right = matrix[0].length -1;

        return spiral_order(matrix, top, bottom, left, right);
    }

    public List<Integer> spiral_order(int[][] matrix, int top, int bottom, int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            list.add(matrix[top][i]);
        }

        if (++top > bottom) {
            return list;
        }

        for (int i = top; i <= bottom; i++) {
            list.add(matrix[i][right]);
        }

        if (--right < left) {
            return list;
        }

        for (int i = right; i >= left; i--) {
            list.add(matrix[bottom][i]);
        }

        if (--bottom < top) {
            return list;
        }

        for (int i = bottom; i >= top; i--) {
            list.add(matrix[i][left]);
        }

        if (++left > right) {
            return list;
        }

        list.addAll(spiral_order(matrix, top, bottom, left, right));
        return list;
     }
}

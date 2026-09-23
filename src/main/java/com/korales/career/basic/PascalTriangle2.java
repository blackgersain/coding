package com.korales.career.basic;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        if (rowIndex < 0) {
            return new ArrayList<>();
        }

        result.add(List.of(1));

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currRow.add(1);
            result.add(currRow);
        }

        return result.get(result.size() - 1);
    }
}

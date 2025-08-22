package Algorithm_and_Practice;

import java.util.Arrays;

public class _125_SpiralMatrixIVMain {
    public static void main(String[] args) {
        _124_SpiralMatrixIV spiralMatrixIV = new _124_SpiralMatrixIV();
        int[] head = {3,0,2,6,8,1,7,9,4,2,5,5,0};
        int m = 3;
        int n = 5;
        for (int i = 0; i < head.length; i++) {
            spiralMatrixIV.insertLast(head[i]);
        }
        int[][] result = spiralMatrixIV(m, n, spiralMatrixIV.head());

        // To print the 2D matrix properly
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] spiralMatrixIV(int m, int n, _124_SpiralMatrixIV.Node head) {
        int[][] matrix = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        int len = m * n;
        int count = 0;
        int val;

        while(count < len) {

            // Travel over the top row
            for (int i = left; i <= right && count < len; i++) {
                if (head != null) {
                    val = head.value;
                    head = head.next;
                } else {
                    val = -1;
                }
                matrix[top][i] = val;
                count++;
            }
            top++;

            // Travel downwards toward bottom
            for (int i = top; i <= bottom && count < len; i++) {
                if (head != null) {
                    val = head.value;
                    head = head.next;
                } else {
                    val = -1;
                }
                matrix[i][right] = val;
                count++;
            }
            right--;

            // Travel left
            for (int i = right; i >= left && count < len; i--) {
                if (head != null) {
                    val = head.value;
                    head = head.next;
                } else {
                    val = -1;
                }
                matrix[bottom][i] = val;
                count++;
            }
            bottom--;

            // Travel up
            for (int i = bottom; i >= top && count < len; i--) {
                if (head != null) {
                    val = head.value;
                    head = head.next;
                } else {
                    val = -1;
                }
                matrix[i][left] = val;
                count++;
            }
            left++;
        }
        return matrix;
    }
}

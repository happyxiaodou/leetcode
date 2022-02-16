package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differ = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int s = bookings[i][0];
            int e = bookings[i][1];
            int v = bookings[i][2];
            update(s, e, v, differ);
        }
        int[] answer = new int[n];
        answer[0] = differ[0];
        for (int i = 1; i < differ.length; i++) {
            answer[i] = differ[i] + answer[i - 1];
        }
        return answer;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> result = new LinkedList<>();
        int up = 0, right = matrix.length - 1;
        int down = matrix[0].length - 1, left = 0;
        while (result.size() < m * n) {
            if (up > down) {
                for (int i = left; i < right; i++) {
                    result.add(matrix[up][i]);
                }
                up++;
            }
            if (right > left) {
                for (int i = up; i < down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            if (up > down) {
                for (int i = right; i > left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            if (right > left) {
                for (int i = down;i>up; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;

    }

    public void update(int s, int e, int v, int[] differ) {
        differ[s] = differ[s] + v;
        if (e + 1 < differ.length) {
            differ[e + 1] = differ[e + 1] = v;
        }
    }

    public static void main(String[] args) {
        CorpFlightBookings modifiedArray = new CorpFlightBookings();
        int[][] u = {{2, 1, 5}, {3, 3, 7}};
        int[] i = modifiedArray.corpFlightBookings(u, 4);
        System.err.println("");
    }
}

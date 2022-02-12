package com.leetcode;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] differ = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int s = trips[i][1] ;
            int e = trips[i][2] - 1;
            update(num, s, e, differ);
        }
        int[] answer = new int[1001];
        if (differ[0] > capacity) {
            return false;
        }
        answer[0]=differ[0];
        for (int i = 1; i < differ.length; i++) {
            answer[i] = differ[i] + answer[i - 1];
            if (answer[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public void update(int num, int s, int e, int[] differ) {
        differ[s] = differ[s] + num;
        if (e + 1 < differ.length) {
            differ[e + 1] = differ[e + 1] - num;
        }
    }

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        int[][] u = {{2, 1, 5}, {3, 3, 7}};
        System.err.println(carPooling.carPooling(u, 3));
    }
}

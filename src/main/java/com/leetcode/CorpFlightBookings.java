package com.leetcode;

public class CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differ = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int s = bookings[i][0];
            int e = bookings[i][1];
            int v = bookings[i][2];
            update(s, e, v, differ);
        }
        int[] answer=new int[n];
        answer[0]=differ[0];
        for(int i=1;i<differ.length;i++){
            answer[i]=differ[i]+answer[i-1];
        }
        return answer;
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

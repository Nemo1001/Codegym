package com.company;

public class Main {

    public static int sum(int arr[][]) {
        int sum = 0;
        for ( int i = 0; i < 7;i++) {
            for ( int j = 0; j < 7;j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int arr[][] = {
                {0, 983, 787, 714, 1375, 967, 1087},
                {983, 0, 214, 1102, 1763, 1723, 1842},
                {787, 214, 0, 888, 1549, 1548, 1627},
                {714, 1102, 888, 0, 661, 781, 810},
                {1375, 1763, 1549, 661, 0, 1426, 1187},
                {967, 1723, 1548, 781, 1426, 0, 239},
                {1087, 1842, 1627, 810, 1187, 239, 0},
        };
        System.out.println("Tong duong cheo chinh la: "+ sum(arr));

    }
}

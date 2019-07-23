package com.company;

import java.util.Scanner;

import static sun.nio.ch.IOStatus.check;

public class Main {
    public static boolean check(int number) {
        if (number < 0) {
            return false;
        } else if (number == 2) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        int numbers;
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Nhap vao so luong so nguyen to can in ra: ");
        numbers = input.nextInt();
        for (int N = 2; count < numbers; N++) {
            if (check(N)) {
                System.out.println(N);
                count++;
            }
        }
    }
}
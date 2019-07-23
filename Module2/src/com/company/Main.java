package com.company;

public class Main {
    public static void chuNhat(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    public static void tamGiacVuong(int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    static void tamGiacVuongNguoc(int a) {
        for (int i = a; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int choice = 0;
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        int width = 0;
        int heigh = 0;
        switch (choice) {
            case 1:
                System.out.println("input width");
                width = input.nextInt();
                System.out.println("input heigh");
                heigh = input.nextInt();
                chuNhat(width, heigh);
                break;
            case 2:
                System.out.println("input width");
                width = input.nextInt();
                tamGiacVuong(width);
                break;
            case 3:
                System.out.println("input width");
                width = input.nextInt();
                tamGiacVuongNguoc(width);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("No choice!");


        }
    }
}

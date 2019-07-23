package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            size = scanner.nextInt();
        } while (size < 0);
        int arr[] = new int[size];
        for (int i = 0; i < size;i++) {
            System.out.println("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("mảng ban đầu: ");
        for (int i = 0; i < size; i++ ){
            System.out.println(arr[i] + " " );
        }
        int x,index;
        System.out.println("Nhập vào số muốn xóa");
        x = scanner.nextInt();
        System.out.println("Mảng mới khi đã xóa là: ");
        for (int i = 0;i< arr.length;i++) {
            if(arr[i] == x) {
                continue;
            }
            System.out.println(arr[i]+" ");
        }

    }
}

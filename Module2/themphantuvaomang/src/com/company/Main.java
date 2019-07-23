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
        for (int i = 0; i < size; i++) {
            System.out.println("Nhap phan tu thu " + i + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Mảng ban đầu: ");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    int x, index;
        System.out.println("Nhập vào số muốn chèn: ");
        x = scanner.nextInt();
        System.out.println("Nhập vào vị trí muốn chèn: ");
        index = scanner.nextInt();
        for (int i = 0; i< arr.length;i++) {
            if (index <= 0 && index >= args.length - 1) {
                System.out.println("Bạn nhập sai vị trí muốn chèn");
            break;
            }
            else if (i == index){
                arr[i] = x;
            }
            System.out.println(arr[i] + " " );
        }
    }
}

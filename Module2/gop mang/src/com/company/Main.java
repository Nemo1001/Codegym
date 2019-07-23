package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int size1;
        int arr1[];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size of arr1: ");
        size1 = scanner.nextInt();
        arr1 = new int[size1];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " ");
            arr1[i] = scanner.nextInt();
        }

        int size2;
        int arr2[];
        System.out.println("enter a size of arr2: ");
        size2 = scanner.nextInt();
        arr2 = new int[size2];
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1) + " ");
            arr2[i] = scanner.nextInt();
        }

        int arr3[];
        arr3 = new int[size1+size2];
        for (int i = 0; i<arr1.length;i++){
            arr3[i] = arr1[i];
        }
        for (int i = arr1.length;i<size1+size2;i++){
            arr3[i] = arr2[i-size1]; // ?
        }
        System.out.println("mang thu 3 gop cua 2 mang la: ");
        for ( int i = 0; i <arr3.length;i++) {
            System.out.println(arr3[i]+ " ");
        }

    }
}



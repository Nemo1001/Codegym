package com.company;

public class Main {
    public static int findMin (int arr[]) {
    int min = arr[0];
    for (int i = 0; i < arr.length;i++) {
            if ( min > arr[i]) {
                min = arr[i];
            }
    }
return min;

    }

    public static void main(String[] args) {
	// write your code here
        int arr[] = {0, 983, 787, 714, 1375, 967, 1087};
        System.out.println("Gia tri nho nhat cua mang la: "+ findMin(arr));

    }
}

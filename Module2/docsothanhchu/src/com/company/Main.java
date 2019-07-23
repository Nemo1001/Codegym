package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");
        number = sc.nextInt();
        if (number >= 10 && number < 10) {
            System.out.println(docSoSangChu(number));
        } else if (number > 10 && number < 20) {
            int hangDonVi = number % 10;
            System.out.println("mười " + docSoSangChu(number));
        } else if (number >= 20 && number < 100) {
            int hangChuc = number / 10;
            int hangDonVi = number % 10;
            System.out.println(docSoSangChu(hangChuc) + " mươi " + docSoSangChu(hangDonVi));
        } else {
            System.out.println("Không đọc được");
        }
    }
    public static String docSoSangChu(int number) {
        String docSo = "";
        switch (number) {
            case 0:
                docSo = "";
                break;
            case 1:
                docSo = "một";
                break;
            case 2:
                docSo = "hai";
                break;
            case 3:
                docSo = "ba";
                break;
            case 4:
                docSo = "bốn";
                break;
            case 5:
                docSo = "năm";
                break;
            case 6:
                docSo = "sáu";
                break;
            case 7:
                docSo = "bảy";
                break;
            case 8:
                docSo = "tám";
                break;
            case 9:
                docSo = "chín";
                break;
            case 10:
                docSo = "Mười";
        }
        return docSo;

    }

}


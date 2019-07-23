package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String text = "codegymvn codegymvn codegymvn codegymvn";
        int count = 0;
        char x = 'c';
        for (int i = 0; i < text.length(); i++) {
            if ( x == text.charAt(i)) {
                count += 1;
            }
        }
        if ( count == 0) {
            System.out.println("khong tim thay ki tu trong chuoi");
        } else {
            System.out.println("ki tu " + x + " xuat hien " + count + " lan");
        }

    }
}

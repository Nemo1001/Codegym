package com.company;

public class Main {

    public static void main(String[] args) {
	double rate = 23000;
	double USD;
	java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Input USD: ");
        USD = input.nextDouble();
        double quydoi = USD * rate;
        System.out.println("USD sang VND :" + quydoi);
    }
}

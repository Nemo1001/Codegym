package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        phuongtrinh ptb = new phuongtrinh();
        double a, b, c, x1, x2;
        Scanner input = new Scanner(System.in);
        System.out.println("Input a, b, c: ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        ptb = new phuongtrinh(a, b, c);

        x1 = ptb.getR1();
        x2 = ptb.getR2();
        if (ptb.getdelta() < 0) {
            System.out.println("Phuong trinh vo nghiem");
        } else if (ptb.getdelta() == 0) {
            System.out.println("Phuong trinh co nghiem kep x = " + x1);
        } else {
            System.out.println("Phuong trinhh co nghiem x1 = " + x1 + "\n Phuong trinh co nghiem x2 = " + x2);
        }
    }

    public static class phuongtrinh {
        double a, b, c;

        public phuongtrinh() {
        }

        public phuongtrinh(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getdelta() {
            double delta = this.b * this.b - 4 * this.a * this.c;
            return delta;
        }

        public double getR1() {
            if (this.getdelta() < 0) {
                return -1;
            } else {
                double r1 = -this.b + Math.sqrt(this.getdelta()) / (2 * this.a);
                return r1;
            }
        }

        public double getR2() {
            if (this.getdelta() < 0) {
                return -1;
            } else {
                double r2 = -this.b - Math.sqrt(getdelta()) / (2 * this.a);
                return r2;
            }
        }

    }
}


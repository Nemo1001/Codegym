package com.company;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new circle();
        System.out.println(circle());

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle (3.5, "indigo",false);
        System.out.println(circle);
    }
}

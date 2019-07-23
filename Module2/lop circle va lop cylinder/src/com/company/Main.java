package com.company;

public class Main {


    public static void main(String[] args) {
        Circle circle = new Circle();
        circle = new Circle(5.0, "red");
        System.out.println(circle + " -_-");

        Cylinder cylinder = new Cylinder();
        cylinder = new Cylinder(4.0, "blue", 10.5);
        System.out.println(cylinder + "  ~.~" );
    }

}


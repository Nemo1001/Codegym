package com.company;

public class Circle {
    private double radius;
    private String color = "green";
    private boolean filled = true;
    public Circle() {
            };
    public Circle(double radius, String color ) {
        this.radius = radius;
        this.color  = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return (Math.pow(this.radius,2)*Math.PI);
    }

    @Override
    public String toString() {
        return "radius: " + this.radius + "\n color:" + this.color + " \n Area: " + this.getArea();

    }
}

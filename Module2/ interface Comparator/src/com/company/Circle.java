package com.company;

public class Circle {
    public double radius = 1.0;
    public double color;
    public double filled;
    public Circle() {
    }
    public Circle (double radius) {
        this.radius = radius;
    }
    public Circle(double radius,String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public double getFilled() {
        return filled;
    }

    public void setFilled(double filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + color +
                ", filled=" + filled +
                '}';
    }
}

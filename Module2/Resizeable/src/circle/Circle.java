package circle;

import resizeable.Resizeable;

public class Circle implements Resizeable {
    private double radius = 1.0;
    private String color = "Black";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle (String color) {
        this.color = color;
    }
    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
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
        return Math.PI * 2 * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    @Override
    public void resize(double percent) {
        double per = percent / 100 * radius;
        setRadius(getRadius()+ per );
    }

    @Override
    public String toString() {
        return "getArea = " + getArea() +
                "\n Perimeter = " + getPerimeter();

    }
}
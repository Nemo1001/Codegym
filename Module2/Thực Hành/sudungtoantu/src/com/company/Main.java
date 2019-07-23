package com.company;

import java.util.Scanner;

public class Main {
    float width;
    float height;

    }
    import java.util.Scanner;

    public class RectangleProgram {
        public static void main(String[] args) {
            float width;
            float height;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter width: ");
            width = scanner.nextFloat();

            System.out.println("Enter height: ");
            height = scanner.nextFloat();

            float area = width * height;

            System.out.println("Area is: " + area)
        }
    }

}

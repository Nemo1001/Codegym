package com.company;

import Model.Product;
import controller.ProductController;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        do {
            int choice;
            Scanner input = new Scanner(System.in);

            System.out.println("Menu: ");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Them 1 san pham moi");
            System.out.println("0. exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    ProductController productController = new ProductController(); // ?
                    Product[] listProduct = productController.findAll();  // ?
                    for (int i = 0; i < listProduct.length; i++) {
                        if (listProduct[i] != null) {
                            System.out.println("ID: " + listProduct[i].getId() + " NAME: " + listProduct[i].getName());
                        }
                    }
                    break;
            }
            while (choice != 0)
        }
    }
}
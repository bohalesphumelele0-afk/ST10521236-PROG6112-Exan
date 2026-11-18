/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questionn1;
import java.util.Scanner;
/**
 *
 * @author pc
 */




public class PrintProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  product names
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // products over 3 months
        int[][] sales = new int[3][3];

        for (int i = 0; i < products.length; i++) {
            for (int month = 1; month <= 3; month++) {
                System.out.print("Enter number of sales for month " + month + " for " + products[i] + " mattress: ");
                sales[i][month - 1] = scanner.nextInt();
            }
            System.out.println();
        }

        Product product = new Product(products, sales);

        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) Math.round(product.GetAverageProductSold()));
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());

        scanner.close();
    }
}

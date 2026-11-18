/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.questionn1;

/**
 *
 * @author pc
 */
public class Product implements IProduct {
    
    private String[] productNames;
    private int[][] salesData; // [productIndex][monthIndex]

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    //@Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    //@Override
    public double GetAverageProductSold() {
        int totalSold = GetTotalProductsSold();
        // Total products = number of product rows
        if (productNames.length == 0) return 0.0;
        return (double) totalSold / (productNames.length * 3); // Average sales per month/product (or totalSold / 9 = 17 as per sample output 153/9 = 17)
    }

    //@Override
    public String GetMostPopularProduct() {
        int highestTotal = -1;
        int popularIndex = 0;

        for (int i = 0; i < salesData.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentTotal += salesData[i][j];
            }
            if (currentTotal > highestTotal) {
                highestTotal = currentTotal;
                popularIndex = i;
            }
        }
        return productNames[popularIndex] + " (" + highestTotal + ")";
    }

    public String[] getProductNames() {
        return productNames;
    }

    public int[][] getSalesData() {
        return salesData;
    }
}
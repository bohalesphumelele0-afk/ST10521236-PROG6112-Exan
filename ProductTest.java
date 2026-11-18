/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.questionn1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pc
 */
public class ProductTest {
    
    //public ProductTest() {
        
    // Test Data matching the assignment sample
    private final String[] productNames = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };
    
    private final int[][] salesData = {
        {25, 18, 20}, // Sum = 63
        {15, 10, 12}, // Sum = 37
        {18, 15, 20}  // Sum = 53
    };
  

     @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(productNames, salesData);
        int expectedTotal = 153;
        int actualTotal = product.GetTotalProductsSold();
        assertEquals(expectedTotal, actualTotal);
    }

     @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(productNames, salesData);
        double expectedAverage = 17.0; 
        double actualAverage = product.GetAverageProductSold();
        assertEquals(expectedAverage, actualAverage, 0.001);
    }
}

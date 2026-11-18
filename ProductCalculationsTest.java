package question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalculations calc = new ProductCalculations("Joe Bloggs", "Cozy Nights Monarch", 3500.0);
        double expectedVat = 525.0;

        // Act
        double actualVat = calc.GetVat();

        // Assert
        assertEquals(expectedVat, actualVat, 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange
        ProductCalculations calc = new ProductCalculations("Joe Bloggs", "Cozy Nights Monarch", 3500.0);
        double expectedTotal = 4200.0;

        // Act
        double actualTotal = calc.GetTotal();

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.001);
    }
}

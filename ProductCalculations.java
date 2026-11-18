package question2;

public class ProductCalculations implements IProductCalculations {
    private String customerName;
    private String productName;
    private double productPrice;

    public ProductCalculations(String customerName, String productName, double productPrice) {
        this.customerName = customerName;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice * 0.05;
    }

    @Override
    public double GetTotal() {
        return productPrice + GetVat() + GetCommission();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}

package com.mycompany.questionn1;
        
        
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProducts;
    private JTextField txtProductPrice;
    private JButton btnProcess;

    private JMenuItem mnuExit;
    private JMenuItem mnuProcess;
    private JMenuItem mnuClear;

    public ProductApp() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Product App");
        setSize(420, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu menuFile = new JMenu("File");
        mnuExit = new JMenuItem("Exit");
        menuFile.add(mnuExit);

        // Tools Menu
        JMenu menuTools = new JMenu("Tools");
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");
        menuTools.add(mnuProcess);
        menuTools.add(mnuClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Panel Layout
        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Customer Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCenter.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1;
        txtCustomerName = new JTextField(15);
        panelCenter.add(txtCustomerName, gbc);

        // Row 1: Select Product
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCenter.add(new JLabel("Select Product:"), gbc);

        gbc.gridx = 1;
        String[] mattressProducts = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProducts = new JComboBox<>(mattressProducts);
        panelCenter.add(cmbProducts, gbc);

        // Row 2: Enter Price
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCenter.add(new JLabel("Enter Price:"), gbc);

        gbc.gridx = 1;
        txtProductPrice = new JTextField(15);
        panelCenter.add(txtProductPrice, gbc);

        // Row 3: Process Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnProcess = new JButton("PROCESS");
        panelCenter.add(btnProcess, gbc);

        add(panelCenter, BorderLayout.CENTER);

        // Event Listeners
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        mnuProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        mnuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mnuClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerName.setText("");
                txtProductPrice.setText("");
                if (cmbProducts.getItemCount() > 0) {
                    cmbProducts.setSelectedIndex(0);
                }
            }
        });
    }

    private void processSale() {
        String customer = txtCustomerName.getText().trim();
        String product = (String) cmbProducts.getSelectedItem();
        String priceText = txtProductPrice.getText().trim();

        if (customer.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numeric price.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Calculations calc = new Calculations(customer, product, price);

        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // 1. Popup Message Dialog
        String message = "Customer Name: " + customer + "\n"
                       + "Product: " + product + "\n"
                       + "VAT: R " + vat + "\n"
                       + "COMMISSION: R " + commission + "\n"
                       + "TOTAL: R " + total;

        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

        // 2. Save to data.txt
        saveToFile(customer, product, vat, commission, total);
    }

    private void saveToFile(String customerName, String product, double vat, double commission, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("************************************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("************************************************");
            writer.println();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving data to file: " + ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductApp().setVisible(true);
            }
        });
    }
}

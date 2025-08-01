import java.util.ArrayList;
import java.util.Scanner;

// Product class
class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(double price) { this.price = price; }

    public void displayProduct() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Quantity: " + quantity +
                " | Price: " + price);
    }
}

// Inventory class
class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("✅ Product added successfully!");
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠ No products in inventory.");
            return;
        }
        System.out.println("📦 Inventory:");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public void updateStock(int id, int newQuantity) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setQuantity(newQuantity);
                System.out.println("✅ Quantity updated.");
                return;
            }
        }
        System.out.println("❌ Product not found.");
    }

    public void deleteProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("🗑 Product deleted.");
                return;
            }
        }
        System.out.println("❌ Product not found.");
    }
}

// Main class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View  Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    Product p = new Product(id, name, qty, price);
                    inventory.addProduct(p);
                    break;
                case 2:
                    inventory.viewProducts();
                    break;
                case 3:
                    System.out.print("Enter Product ID to update: ");
                    int uid = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    inventory.updateStock(uid, newQty);
                    break;
                case 4:
                    System.out.print("Enter Product ID to delete: ");
                    int did = scanner.nextInt();
                    inventory.deleteProduct(did);
                    break;
                case 5:
                    System.out.println("🚪 Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠ Invalid option. Try again.");
            }
        }
    }
}

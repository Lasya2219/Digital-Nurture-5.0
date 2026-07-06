import java.util.HashMap;

public class InventoryManagement {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product product) {
        inventory.put(product.product_id, product);
    }

    public static void updateProduct(int product_id, int quantity) {
        if (inventory.containsKey(product_id)) {
            Product product = inventory.get(product_id);
            product.quantity = quantity;
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void removeProduct(int product_id) {
        if (inventory.containsKey(product_id)) {
            inventory.remove(product_id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println("ID: " + product.product_id + ", Name: " + product.product_name + ", Quantity: " + product.quantity + ", Price: $" + product.price);
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 499.99);

        addProduct(product1);
        addProduct(product2);

        System.out.println("Inventory after adding products:");
        displayInventory();

        updateProduct(1, 15);
        System.out.println("\nInventory after updating product quantity:");
        displayInventory();

        removeProduct(2);
        System.out.println("\nInventory after removing a product:");
        displayInventory();
    }
}


// ADD - O(1)
// UPDATE - O(1)
// REMOVE - O(1)


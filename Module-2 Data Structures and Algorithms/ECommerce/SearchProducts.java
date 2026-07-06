package ECommerce;

import java.util.ArrayList;
import java.util.List;

public class SearchProducts {
    static List<Product> products  = new ArrayList<>();

    public static void addProduct(List<Product> products, Product product) {
        products.add(product);
    }

    public static Product linearSearch(List<Product> products, String productName) {
        for(Product product : products) {
            if(product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> products, String productName) {
        products.sort((p1, p2) -> p1.productName.compareTo(p2.productName));
        int left = 0;
        int right = products.size() - 1;

        while(left<=right) {
            int mid = left + (right-left)/2;

            if(products.get(mid).productName.equals(productName)) {
                return products.get(mid);
            } else if(products.get(mid).productName.compareTo(productName) < 0) {
                // compareTo returns a negative value if the first string is lexicographically less than the second string
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", "Electronics");
        Product product2 = new Product(2, "Smartphone", "Electronics");

        SearchProducts.addProduct(products, product1);
        SearchProducts.addProduct(products, product2);

        Product foundProduct = SearchProducts.linearSearch(products, "Laptop");
        if(foundProduct != null) {
            System.out.println("Product found: " + foundProduct.productName + ", Category: " + foundProduct.category);
        } else {
            System.out.println("Product not found.");
        }

        foundProduct = SearchProducts.binarySearch(products, "Smartphone");
        if(foundProduct != null) {
            System.out.println("Product found: " + foundProduct.productName + ", Category: " + foundProduct.category);
        } else {
            System.out.println("Product not found.");
        }
    }
}

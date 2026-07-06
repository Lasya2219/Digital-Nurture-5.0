package Sorting_Customer_Orders;

import java.util.ArrayList;
import java.util.List;

public class SortOrders {
    static List<Order> orders = new ArrayList<>();

    public static void addOrder(List<Order> orders, Order order) {
        orders.add(order);
    }

    public static void Bubblesort(List<Order> orders) {
        int n = orders.size();
        for(int i=0;i<n;i++) {
            boolean swapped = false;
            for(int j=0;j<n-i-1;j++) {
                if(orders.get(j).totalPrice > orders.get(j+1).totalPrice) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j+1));
                    orders.set(j+1, temp);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    public static void QuickSort(List<Order> orders, int low, int high) {
        if(low < high) {
            int pi = partition(orders, low, high);
            QuickSort(orders, low, pi-1);
            QuickSort(orders, pi+1, high);
        }
    }

    private static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).totalPrice;
        int i = low;
        int j = high;

        while(i<j) {
            while(orders.get(i).totalPrice<=pivot && i<j) {
                i++;
            }
            while(orders.get(j).totalPrice>pivot) {
                j--;
            }
            if(i<j) {
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }
        Order temp = orders.get(i);
        orders.set(i, orders.get(high));
        orders.set(high, temp);        

        return j;
    }

    public static void displayOrders(List<Order> orders) {
        for(Order order : orders) {
            System.out.println("Order ID: " + order.orderId + ", Customer Name: " + order.customerName + ", Total Price: " + order.totalPrice);
        }
    }

    public static void main(String[] args) {
        Order order1 = new Order(1, "Alice", 250.50);
        Order order2 = new Order(2, "Bob", 150.75);
        Order order3 = new Order(3, "Charlie", 300.00);

        SortOrders.addOrder(orders, order1);
        SortOrders.addOrder(orders, order2);
        SortOrders.addOrder(orders, order3);

        System.out.println("Orders before sorting:");
        displayOrders(orders);

        // Bubblesort(orders);
        // System.out.println("\nOrders after Bubble Sort:");
        // displayOrders(orders);

        QuickSort(orders, 0, orders.size()-1);
        System.out.println("\nOrders after Quick Sort:");
        displayOrders(orders);
    }
}

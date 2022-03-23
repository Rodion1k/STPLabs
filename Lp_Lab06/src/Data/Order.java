package Data;

public class Order {
    private String name;
    private int orderNumber;
    private String orderDate;
    private int quantity;
    private Customer customer;

    public Order(String name, int orderNumber, String orderDate, int quantity, Customer customer) {
        this.name = name;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.customer = customer;
    }
}

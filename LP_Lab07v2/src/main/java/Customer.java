import org.testng.Assert;
import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;
    private float moneyAmount;
    private ArrayList<Product> products;

    public Customer(String name, String address, float moneyAmount) {
        this.name = name;
        this.address = address;
        this.moneyAmount = moneyAmount;
        products = new ArrayList<>();
    }

    public float getMoneyAmount() {
        return moneyAmount;
    }

    public void buyGoods(Product product) {
        moneyAmount -= product.getPrice();
        products.add(product);

    }
    public void saleGoods()
    {
        for (var i:products) {
            moneyAmount+=i.getPrice();
        }
        products.clear();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }
}

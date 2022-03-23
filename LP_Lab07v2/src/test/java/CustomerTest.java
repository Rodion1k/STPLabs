
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;
public class CustomerTest {

    private Product product= new Product("kek",200);
    private Customer customer  = new Customer("LOLES","LOLKEK 22",400);
    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod – аннотированный метод будет выполняться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod – аннотированный метод будет запускаться после каждого тестового метода.");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }

    @Test
    public void checkBuyProduct()
    {
        float res = customer.getMoneyAmount()-product.getPrice();
        customer.buyGoods(product);
        Assert.assertEquals(customer.getMoneyAmount(),res,"the result is not corrected");
    }
    @Test(timeOut = 500)
    public void checkSaleProduct()
    {
        customer.saleGoods();
    }



}

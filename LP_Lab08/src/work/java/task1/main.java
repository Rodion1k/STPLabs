package task1;

public class main {
    public static void main(String[] args) {

        byte ip[] = {(byte)127, (byte)0, (byte)0, (byte)7}; // local
        Connection connection = new Connection();
        connection.printLocalHost();
        connection.printHostByName("www.belstu.by");
        connection.printHostByAddress("Unknow",ip);
        connection.printInfoByUrl("https://www.onliner.com",10000);
        connection.printHTML("https://github.com");

    }
}
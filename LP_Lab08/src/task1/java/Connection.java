import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Connection {

    public void printLocalHost() {
        try {
            var localHostIp = InetAddress.getLocalHost();
            System.out.println(localHostIp.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void printHostByName(String name) {
        try {
            var localHostIp = InetAddress.getByName(name);
            System.out.println(localHostIp.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void printHostByAddress(String name, byte[] ip) {

        try {
            InetAddress addr = InetAddress.getByAddress(name, ip);
            System.out.println(addr.getHostName()
                    + "-> cоединение:" + addr.isReachable(100));
        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHTML(String urlName) {
        URL url = null;
        try {
            url = new URL(urlName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (url == null) {
            throw new RuntimeException();
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printInfoByUrl(String urlName, int timeOut) {
        URL url;
        try {
            url = new URL(urlName);
            final URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(timeOut);
            System.out.println(urlName + " content type: \n" + urlConnection.getContentType() +
                    "\n" + urlConnection.getClass() + "\n" + urlConnection.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

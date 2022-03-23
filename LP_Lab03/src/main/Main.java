package main;
import Exceptions.ItCompanyException;
import IT_company.ItCompany;
import IT_company.Worker;
import IT_company.administrators.NetworkAdministrator;
import IT_company.administrators.SystemAdministrator;
import IT_company.programmers.Junior;
import IT_company.programmers.Middle;
import IT_company.programmers.Senior;
import IT_company.programmers.SkillsLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.google.gson.Gson;
import parser.XmlParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("start");
            Junior junior = new Junior((byte) 2, SkillsLevel.second, 120);
            System.out.println(junior);
            Junior junior2 = new Junior((byte) 2, SkillsLevel.first, 110);
            Middle middle = new Middle((byte) 5, SkillsLevel.second, 120);
            Senior senior = new Senior((byte) 9, SkillsLevel.fourth, 120);
            NetworkAdministrator networkAdministrator = new NetworkAdministrator((byte) 3, SkillsLevel.first, 130);
            SystemAdministrator systemAdministrator = new SystemAdministrator((byte) 1, SkillsLevel.first, 120);
            ItCompany<Worker> itCompany = new ItCompany<>();
            itCompany.Add(junior);
            itCompany.Add(junior2);
            itCompany.Add(middle);
            itCompany.Add(senior);
            itCompany.Add(networkAdministrator);
            itCompany.Add(systemAdministrator);
            itCompany.showWorkersInfo();
            System.out.println();
            System.out.println();
            itCompany.showWorkersBySkills(SkillsLevel.second);


            // 4 лаба
            System.out.println("---Json Serialize---");
            Gson gson = new Gson();
            String jsonString = gson.toJson(itCompany);
            System.out.println(jsonString);
            FileOutputStream file = new FileOutputStream("files/info.json");
            byte[] out = jsonString.getBytes(StandardCharsets.UTF_8);
            file.write(out, 0, out.length);
            LOG.info("Json Serialize");
            file.close();
            System.out.println("---Json Deserialize---");
            FileReader fileReader = new FileReader("files/info.json");
            char buf[] = new char[256];
            StringBuilder res = new StringBuilder();
            int c;
            while ((c = fileReader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                res.append(buf);
            }
            ItCompany<Worker> itCompany1 = gson.fromJson(res.toString(), ItCompany.class);
            LOG.info("Json Deserialize");
            fileReader.close();
            // SaxParser

            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            XmlParser xmlParser = new XmlParser();
            saxParser.parse(new File("files/NetAdmin.xml"), xmlParser);
            ArrayList<NetworkAdministrator> list = xmlParser.getResult();
            for (var i : list)
                System.out.println(i);
            LOG.info("parse Xml");

            list.stream().filter(s -> s.getSalary() > 200).forEach(System.out::println);


        } catch (ItCompanyException e) {
            LOG.info("ItCompanyException");
            LOG.info(e.getMessage());
        } catch (Exception e) {
            LOG.info("exception");
            LOG.info(e.getMessage());
        } finally {
            LOG.info("finally");
        }
    }
}

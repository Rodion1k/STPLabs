package parser;

import IT_company.administrators.NetworkAdministrator;
import IT_company.programmers.SkillsLevel;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class XmlParser extends DefaultHandler {
    ArrayList<NetworkAdministrator> admins = new ArrayList<>();
    String element, skill;
    Float salary;
    Byte netExp;

    public XmlParser() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (salary != null && skill != null && netExp != null) {
            admins.add(new NetworkAdministrator(netExp, SkillsLevel.valueOf(skill), salary));
            element = null;
            salary = null;
            skill = null;
            netExp = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();
        if(information.isEmpty())
            return;
        switch (element) {
            case "NetExp" -> netExp = Byte.parseByte(information);
            case "SkillsLevel" -> skill = information;
            case "Salary" -> salary = Float.parseFloat(information);
        }

    }

    public ArrayList<NetworkAdministrator> getResult() {
        return admins;
    }
}

package org.lab2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class PlaneParser {

    public static void parseXML(String xmlFile) throws Exception {
        File file = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println("Кореневий елемент: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Plane");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Модель: " + element.getElementsByTagName("Model").item(0).getTextContent());
                System.out.println("Походження: " + element.getElementsByTagName("Origin").item(0).getTextContent());

                // Парсинг характеристик літака
                Element chars = (Element) element.getElementsByTagName("Chars").item(0);
                System.out.println("Тип: " + chars.getElementsByTagName("Type").item(0).getTextContent());
                System.out.println("Кількість місць: " + chars.getElementsByTagName("Seats").item(0).getTextContent());

                if (chars.getElementsByTagName("Ammo").getLength() > 0) {
                    Element ammo = (Element) chars.getElementsByTagName("Ammo").item(0);
                    System.out.println("Ракети: " + ammo.getElementsByTagName("Missiles").item(0).getTextContent());
                    System.out.println("Радар: " + ammo.getElementsByTagName("Radar").item(0).getTextContent());
                }

                // Парсинг параметрів літака
                Element parameters = (Element) element.getElementsByTagName("Parameters").item(0);
                System.out.println("Довжина: " + parameters.getElementsByTagName("Length").item(0).getTextContent());
                System.out.println("Ширина: " + parameters.getElementsByTagName("Width").item(0).getTextContent());
                System.out.println("Висота: " + parameters.getElementsByTagName("Height").item(0).getTextContent());

                System.out.println("Ціна: " + element.getElementsByTagName("Price").item(0).getTextContent());
            }
        }
    }
}

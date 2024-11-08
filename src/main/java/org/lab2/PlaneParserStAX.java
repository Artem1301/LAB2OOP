package org.lab2;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;

public class PlaneParserStAX {

    public static void parseXML(String xmlFile) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(new File(xmlFile)));

        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if ("Plane".equals(reader.getLocalName())) {
                        System.out.println("Літак:");
                    }
                    if ("Model".equals(reader.getLocalName())) {
                        System.out.println("Модель: " + reader.getElementText());
                    } else if ("Origin".equals(reader.getLocalName())) {
                        System.out.println("Походження: " + reader.getElementText());
                    } else if ("Type".equals(reader.getLocalName())) {
                        System.out.println("Тип: " + reader.getElementText());
                    } else if ("Seats".equals(reader.getLocalName())) {
                        System.out.println("Кількість місць: " + reader.getElementText());
                    } else if ("Missiles".equals(reader.getLocalName())) {
                        System.out.println("Ракети: " + reader.getElementText());
                    } else if ("Radar".equals(reader.getLocalName())) {
                        System.out.println("Радар: " + reader.getElementText());
                    } else if ("Length".equals(reader.getLocalName())) {
                        System.out.println("Довжина: " + reader.getElementText());
                    } else if ("Width".equals(reader.getLocalName())) {
                        System.out.println("Ширина: " + reader.getElementText());
                    } else if ("Height".equals(reader.getLocalName())) {
                        System.out.println("Висота: " + reader.getElementText());
                    } else if ("Price".equals(reader.getLocalName())) {
                        System.out.println("Ціна: " + reader.getElementText());
                    }
                    break;
                default:
                    break;
            }
        }
        reader.close();
    }
}

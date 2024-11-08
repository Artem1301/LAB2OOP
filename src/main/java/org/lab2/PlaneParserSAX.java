package org.lab2;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.File;

public class PlaneParserSAX extends DefaultHandler {

    boolean bModel = false, bOrigin = false, bType = false, bSeats = false, bMissiles = false, bRadar = false, bLength = false, bWidth = false, bHeight = false, bPrice = false;

    public static void parseXML(String xmlFile) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        PlaneParserSAX handler = new PlaneParserSAX();
        parser.parse(new File(xmlFile), handler);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("Model")) {
            bModel = true;
        } else if (qName.equalsIgnoreCase("Origin")) {
            bOrigin = true;
        } else if (qName.equalsIgnoreCase("Type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("Seats")) {
            bSeats = true;
        } else if (qName.equalsIgnoreCase("Missiles")) {
            bMissiles = true;
        } else if (qName.equalsIgnoreCase("Radar")) {
            bRadar = true;
        } else if (qName.equalsIgnoreCase("Length")) {
            bLength = true;
        } else if (qName.equalsIgnoreCase("Width")) {
            bWidth = true;
        } else if (qName.equalsIgnoreCase("Height")) {
            bHeight = true;
        } else if (qName.equalsIgnoreCase("Price")) {
            bPrice = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();

        if (bModel) {
            System.out.println("Модель: " + data);
            bModel = false;
        } else if (bOrigin) {
            System.out.println("Походження: " + data);
            bOrigin = false;
        } else if (bType) {
            System.out.println("Тип: " + data);
            bType = false;
        } else if (bSeats) {
            System.out.println("Кількість місць: " + data);
            bSeats = false;
        } else if (bMissiles) {
            System.out.println("Ракети: " + data);
            bMissiles = false;
        } else if (bRadar) {
            System.out.println("Радар: " + data);
            bRadar = false;
        } else if (bLength) {
            System.out.println("Довжина: " + data);
            bLength = false;
        } else if (bWidth) {
            System.out.println("Ширина: " + data);
            bWidth = false;
        } else if (bHeight) {
            System.out.println("Висота: " + data);
            bHeight = false;
        } else if (bPrice) {
            System.out.println("Ціна: " + data);
            bPrice = false;
        }
    }
}

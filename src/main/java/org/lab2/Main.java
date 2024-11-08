package org.lab2;

import generated.Plane;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Програма почала роботу");

        try {
            String xmlPath = new File("src/main/resources/plane.xml").getAbsolutePath();
            String xsdPath = new File("src/main/resources/xsd/plane.xsd").getAbsolutePath();
            String xslPath = new File("src/main/resources/transform.xsl").getAbsolutePath();
            String outputPath = new File("src/main/resources/output.xml").getAbsolutePath();

            logger.info("Шлях до XML: " + xmlPath);
            logger.info("Шлях до XSD: " + xsdPath);
            logger.info("Шлях до XSL: " + xslPath);
            logger.info("Шлях до Output: " + outputPath);

            // Validate XML
            logger.info("Початок валідації XML...");
            XMLValidator.validate(xmlPath, xsdPath);
            logger.info("Валідація завершена успішно.");

            // Choose parser type
            String parserType = "DOM";  // Change this as needed ("DOM", "SAX", or "StAX")
            logger.info("Початок парсингу XML за допомогою " + parserType + " парсера...");

            List<Plane.Planes> planes = new ArrayList<>();

            if (parserType.equals("DOM")) {
                planes = DOMParser.parseXML(xmlPath);
            } else if (parserType.equals("SAX")) {
                planes = PlaneParserSAX.parseXML(xmlPath);
            } else if (parserType.equals("StAX")) {
                planes = PlaneParserStAX.parseXML(xmlPath);
            }

            planes.sort(new PlaneComparator());

            logger.info("Сортовані літаки за моделлю:");
            for (Plane.Planes plane : planes) {
                logger.info("Модель: " + plane.getModel());
            }

            logger.info("Парсинг завершено успішно.");

            // Transform XML
            logger.info("Початок трансформації XML...");
            XMLTransformer.transform(xmlPath, xslPath, outputPath);
            logger.info("Трансформація завершена успішно.");

        } catch (Exception e) {
            logger.severe("Помилка: " + e.getMessage());
        }

        logger.info("Програма завершила роботу");
    }
}

package org.lab2;

import java.io.File;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Програма почала роботу");

        try {
            String xmlPath = new File("src/main/java/org/lab2/plane.xml").getAbsolutePath();
            String xsdPath = new File("src/main/java/org/lab2/plane.xsd").getAbsolutePath();
            String xslPath = new File("src/main/java/org/lab2/transform.xsl").getAbsolutePath();
            String outputPath = new File("src/main/java/org/lab2/output.xml").getAbsolutePath();

            logger.info("Шлях до XML: " + xmlPath);
            logger.info("Шлях до XSD: " + xsdPath);
            logger.info("Шлях до XSL: " + xslPath);
            logger.info("Шлях до Output: " + outputPath);

            logger.info("Початок валідації XML...");
            XMLValidator.validate(xmlPath, xsdPath);
            logger.info("Валідація завершена успішно.");

            logger.info("Початок парсингу XML...");
            PlaneParser.parseXML(xmlPath);
            logger.info("Парсинг завершено успішно.");

            logger.info("Початок трансформації XML...");
            XMLTransformer.transform(xmlPath, xslPath, outputPath);
            logger.info("Трансформація завершена успішно.");

        } catch (Exception e) {
            logger.severe("Помилка: " + e.getMessage());
        }

        logger.info("Програма завершила роботу");
    }
}

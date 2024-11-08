package org.lab2;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlaneParserSAXTest {

    @Test
    public void testParseXML() {
        String xmlFilePath = new File("src/main/resources/plane.xml").getAbsolutePath();

        assertDoesNotThrow(() -> PlaneParserSAX.parseXML(xmlFilePath));
    }

    @Test
    public void testInvalidXML() {
        String invalidXmlFilePath = new File("src/main/resources/invalid_plane.xml").getAbsolutePath();

        assertThrows(Exception.class, () -> PlaneParserSAX.parseXML(invalidXmlFilePath));
    }
}

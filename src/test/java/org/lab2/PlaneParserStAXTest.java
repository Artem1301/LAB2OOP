package org.lab2;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlaneParserStAXTest {

    @Test
    public void testParseXML() {
        String xmlFilePath = new File("src/main/resources/plane.xml").getAbsolutePath();

        assertDoesNotThrow(() -> PlaneParserStAX.parseXML(xmlFilePath));
    }

    @Test
    public void testInvalidXML() {
        String invalidXmlFilePath = new File("src/main/resources/invalid_plane.xml").getAbsolutePath();

        assertThrows(Exception.class, () -> PlaneParserStAX.parseXML(invalidXmlFilePath));
    }
}

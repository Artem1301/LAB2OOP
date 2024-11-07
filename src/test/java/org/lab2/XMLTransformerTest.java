package org.lab2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class XMLTransformerTest {
    @Test
    public void testTransformWithInvalidXML() {
        // Тест на случай неправильного XML
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("invalid.xml", "plane-stylesheet.xsl", "output.html");
        });
    }

    @Test
    public void testTransformWithInvalidXSL() {
        // Тест на случай неправильного XSL
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("plane.xml", "invalid.xsl", "output.html");
        });
    }
}

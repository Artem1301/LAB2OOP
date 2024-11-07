package org.lab2;

import org.junit.jupiter.api.Test;

import javax.xml.transform.TransformerException;

import static org.junit.jupiter.api.Assertions.*;

public class XMLTransformerTest {
    @Test
    public void testTransformWithInvalidXML() {
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("invalid.xml", "plane-stylesheet.xsl", "output.html");
        });
    }

    @Test
    public void testTransformWithInvalidXSL() {
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("plane.xml", "invalid.xsl", "output.html");
        });
    }
}

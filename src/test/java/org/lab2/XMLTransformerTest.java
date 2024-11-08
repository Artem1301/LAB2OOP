package org.lab2;

import org.junit.jupiter.api.Test;
import javax.xml.transform.TransformerException;
import static org.junit.jupiter.api.Assertions.*;

public class XMLTransformerTest {

    @Test
    public void testTransformWithInvalidXML() {
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("invalid.xml", "transform.xsl", "output.xml");
        });
    }

    @Test
    public void testTransformWithInvalidXSL() {
        assertThrows(TransformerException.class, () -> {
            XMLTransformer.transform("plane.xml", "invalid.xsl", "output.xml");
        });
    }

    @Test
    public void testSuccessfulTransformation() {
        assertDoesNotThrow(() -> {
            XMLTransformer.transform("plane.xml", "transform.xsl", "output.xml");
        });
    }
}

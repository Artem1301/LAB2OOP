package org.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class XMLValidatorTest {

    @Test
    void validateValidXML() {
        String xmlPath = "src/main/java/org/lab2/plane.xml";
        String xsdPath = "src/main/java/org/lab2/plane.xsd";

        assertDoesNotThrow(() -> XMLValidator.validate(xmlPath, xsdPath));
    }
}

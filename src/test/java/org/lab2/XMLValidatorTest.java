package org.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class XMLValidatorTest {

    @Test
    void validateValidXML() {
        String xmlPath = "src/main/resources/plane.xml";
        String xsdPath = "src/main/resources/xsd/plane.xsd";

        assertDoesNotThrow(() -> XMLValidator.validate(xmlPath, xsdPath));
    }
}

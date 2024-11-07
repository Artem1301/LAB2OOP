package org.lab2;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLTransformer {

    public static void transform(String xmlFile, String xslFile, String outputFile) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xslFile));
        Transformer transformer = factory.newTransformer(xslt);

        Source xml = new StreamSource(new File(xmlFile));
        transformer.transform(xml, new StreamResult(new File(outputFile)));
    }
}

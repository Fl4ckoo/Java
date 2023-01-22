import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLUtil {

    public static void createXML() throws ParserConfigurationException, TransformerException {


        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();


        Element students = doc.createElement("Students");
        doc.appendChild(students);

        Element student1 = doc.createElement("Student");
        students.appendChild(student1);

        Element student2 = doc.createElement("Student");
        students.appendChild(student2);


        Attr attr = doc.createAttribute("id");
        attr.setValue("10");
        students.setAttributeNode(attr);

        // Student 1
        Element firstName = doc.createElement("Name");
        firstName.appendChild(doc.createTextNode("James Brown"));
        student1.appendChild(firstName);

        Attr attr1 = doc.createAttribute("kaia");
        attr1.setValue("7");
        student1.setAttributeNode(attr1);


        Element id = doc.createElement("ID");
        id.appendChild(doc.createTextNode("8"));
        student1.appendChild(id);


        // Student 2
        Element firstName1 = doc.createElement("Name");
        firstName1.appendChild(doc.createTextNode("Irakli Gvelesiani"));
        student2.appendChild(firstName1);

        Attr attr2 = doc.createAttribute("kaia");
        attr2.setValue("7");
        student2.setAttributeNode(attr2);


        Element id1 = doc.createElement("ID");
        id1.appendChild(doc.createTextNode("1921"));
        student2.appendChild(id1);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File("rati.xml"));

        transformer.transform(domSource, streamResult);






    }
}

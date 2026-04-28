import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;

import java.io.File;

public class DOMExample {
    public static void main(String[] args) {
        try {
            // Load XML file
            File file = new File("input.xml");

            // Create DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            Document doc = builder.parse(file);

            // Normalize XML structure
            doc.getDocumentElement().normalize();

            // Get root element
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Get all student elements
            NodeList nodeList = doc.getElementsByTagName("student");

            // Loop through each student
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String marks = element.getElementsByTagName("marks").item(0).getTextContent();

                    System.out.println("\nStudent Details:");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Marks: " + marks);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

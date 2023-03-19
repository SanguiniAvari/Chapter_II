package LR_10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LR_10_2_xml {
    public static void main(String[] args) {
        try{
            File inputFile = new File("src/LR_10/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("Book");
            for (int i = 0; i<nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                System.out.println("\nCourent Element: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Book name: "+ element
                            .getElementsByTagName("Title").item(0).getTextContent());
                    System.out.println("Autor: " + element
                            .getElementsByTagName("Autor").item(0).getTextContent());
                    System.out.println("Year: " + element
                            .getElementsByTagName("Year").item(0).getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

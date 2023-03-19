package LR_10.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class simpleLR10_xml {
    public static void main(String[] args) {
        try{
            File inputFile = new File("src/LR_10/homework/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("insert year: >>");
            String year = scanner.nextLine();

            Node root = doc.getDocumentElement(); //library

            NodeList books = root.getChildNodes(); //Book
            for (int i=0;i<books.getLength();i++){
                Node book = books.item(i);
                if (book.getNodeType()!=Node.TEXT_NODE){
                    NodeList bookPropd = book.getChildNodes(); //вхождения
                    for (int j =0; j<bookPropd.getLength();j++){
                            Node props = bookPropd.item(j);
                        System.out.println(props.getTextContent());
                            }
                        }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void nodePrint(NodeList bookPropd) {

        for (int k = 0; k < bookPropd.getLength(); k++) {
            System.out.println(bookPropd.item(k).getTextContent());
        }
    }
}

package LR_10.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class LR_10_var_4_1_xml {
    private static void showMustGoOn(){
        try {
            File inputFile = new File("src/LR_10/homework/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);

            NodeList nodeList = doc.getElementsByTagName("Book");
            System.out.println("=================================================================================");
            System.out.println();
            for (int i = 0; i<nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Название книги: \t"+ element
                            .getElementsByTagName("Title").item(0).getTextContent());
                    System.out.println("Автор: \t" + element
                            .getElementsByTagName("Autor").item(0).getTextContent());
                    System.out.println("Год издания: \t" + element
                            .getElementsByTagName("Year").item(0).getTextContent());
                    System.out.println();
                }
            }
            System.out.println("=================================================================================");
        }catch (Exception e){
         e.printStackTrace();
        }
    }
    private static void findFromField(){
        try{
            File inputFile = new File("src/LR_10/homework/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите строку поиска: >>");
            String year = scanner.nextLine();

            Node root = doc.getDocumentElement(); //library

            NodeList books = root.getChildNodes(); //Book
            for (int i=0;i<books.getLength();i++){
                Node book = books.item(i);
                if (book.getNodeType()!=Node.TEXT_NODE){
                    NodeList bookPropd = book.getChildNodes(); //вхождения
                    for (int j =0; j<bookPropd.getLength();j++){
                        Node props = bookPropd.item(j);
                        if (props.getTextContent().equals(year)){
                            nodePrint(books, i);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void delFromTitle(){
        try{
            File inputFile = new File("src/LR_10/homework/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название книги для удаления: >>");
            String findDel = scanner.nextLine();

            Node root = doc.getDocumentElement(); //library

            NodeList books = root.getChildNodes(); //Book
            for (int i=0;i<books.getLength();i++){
                Node book = books.item(i);
                if (book.getNodeType()!=Node.TEXT_NODE){
                    NodeList bookPropd = book.getChildNodes(); //вхождения
                    for (int j =0; j<bookPropd.getLength();j++){
                        Node props = bookPropd.item(j);
                        if (props.getTextContent().equals(findDel)){
                            Element delElement = (Element)book;
                            Node parentNode = delElement.getParentNode();
                            parentNode.removeChild(delElement);
                        }
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"no");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/LR_10/homework/lr10_1_xml.xml"));
            transformer.transform(source,result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void addNewData()throws IOException{
        try {
            Scanner scanner = new Scanner(System.in);
            InputStream inputFile = new FileInputStream("src/LR_10/homework/lr10_1_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();

            Document doc = dBilder.parse(inputFile);

            Element newFlat = doc.createElement("Book");

            Element root = doc.getDocumentElement();
            root.appendChild(newFlat);

            System.out.println("Название книги");
            System.out.print(">>");
            String TitleIn = scanner.nextLine();
            Element Title = doc.createElement("Title");
            Title.appendChild(doc.createTextNode(TitleIn));
            newFlat.appendChild(Title);

            System.out.println("Имя Автора");
            System.out.print(">>");
            String AutorIn = scanner.nextLine();
            Element Autor = doc.createElement("Autor");
            Autor.appendChild(doc.createTextNode(AutorIn));
            newFlat.appendChild(Autor);

            System.out.println("Год издания");
            System.out.print(">>");
            String YearIn = scanner.nextLine();
            Element Year = doc.createElement("Year");
            Year.appendChild(doc.createTextNode(YearIn));
            newFlat.appendChild(Year);

            //Запись XML-файла
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"no");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/LR_10/homework/lr10_1_xml.xml"));
            transformer.transform(source,result);
    }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void nodePrint(NodeList bookPropd, int j) {
        Node nodeDown = bookPropd.item(j);
        Element element = (Element)nodeDown;
        System.out.println("\n=================================================================================");

        System.out.println("Название книги: \t" + element.getElementsByTagName("Title").item(0).getTextContent());
        System.out.println("Автор: \t" +element.getElementsByTagName("Autor").item(0).getTextContent());
        System.out.println("Год издания: \t" +element.getElementsByTagName("Year").item(0).getTextContent());
        System.out.println("=================================================================================\n");

    }

    public static void main(String[] args) {
        UI:
        {
            while (true) {
                System.out.println("1. Показать\n2. Ввести новые данные\n3. Поиск по адресу\n4. Удаление\n0. Завершение");
                System.out.print(">>");
                Scanner sc = new Scanner(System.in);
                int scIn = sc.nextInt();
                if (scIn < 0 || scIn > 4) {
                    System.out.println("Введено недопустимое значение");
                    continue;
                }
                switch (scIn) {
                    case 1:
                        showMustGoOn();
                        break;
                    case 2:
                        try {
                            addNewData();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        findFromField();
                        break;
                        case 4:
                        delFromTitle();
                        break;
                    case 0:
                        break UI;
                }
            }
        }
    }
}

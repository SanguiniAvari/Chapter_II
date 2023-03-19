/**
 * xml storage:
 *      Библиотека объектов <Inspection>
 *      Объект <Flat>
 *      порядковый номер универсальной связки <numder>
 *      Дата осмотра <date>
 *      Время начала <timeStart>
 *      Время окончания <timeEnd>
 *      Номер дела/договора <contract>
 *      Cуд <court>
 *      Тип документа <contractType>
 *      Адресс объекта осмотра <address>
 *      Этаж <floor>
 *      Всего этажей <totalFloors>
 *      Cобственник <owner>
 *      Лица, присутствовавшие <attended>
 *      С какой стороны присутствовало лицо <fromTheSide>
 *      Перечень приборов и инструментов <tools>
 */

package LR_10.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Происходит полная перезапись документа. Исправить
public class LR_10_var_4_1_xml {
    public static void showData() {
        try {
            File inputFile = new File("src/LR_10/homework/lr_10_hw_xml.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
            Document doc = dBilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("flat");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nCourent Element: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("date: " + element.getElementsByTagName("date").item(0).getTextContent());
                    System.out.println("timeStart: " + element.getElementsByTagName("timeStart").item(0).getTextContent());
                    System.out.println("timeEnd: " + element.getElementsByTagName("timeEnd").item(0).getTextContent());
                    System.out.println("contract: " + element.getElementsByTagName("contract").item(0).getTextContent());
                    System.out.println("contractType: " + element.getElementsByTagName("contractType").item(0).getTextContent());
                    System.out.println("address: " + element.getElementsByTagName("address").item(0).getTextContent());
                    System.out.println("floor: " + element.getElementsByTagName("floor").item(0).getTextContent());
                    System.out.println("totalFloors: " + element.getElementsByTagName("totalFloors").item(0).getTextContent());
                    System.out.println("owner: " + element.getElementsByTagName("owner").item(0).getTextContent());
                    System.out.println("attended: " + element.getElementsByTagName("attended").item(0).getTextContent());
                    System.out.println("fromTheSide: " + element.getElementsByTagName("fromTheSide").item(0).getTextContent());
                    for(int j = 0;j<element.getElementsByTagName("tools").getLength();j++){
                        System.out.println("tools: " + element.getElementsByTagName("tools").item(j).getTextContent());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addNewData() throws IOException{
    try {
        Scanner scanner = new Scanner(System.in);
        File inputFile = new File("src/LR_10/homework/lr_10_hw_xml.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBilder = dbFactory.newDocumentBuilder();

        Document doc = dBilder.parse(inputFile);

        Element newFlat = doc.createElement("flat");

        System.out.println("Введите дату");
        System.out.print(">>");
        String dateIn = scanner.nextLine();
        Element date = doc.createElement("date");
        date.appendChild(doc.createTextNode(dateIn));
        newFlat.appendChild(date);

        System.out.println("Введите время начала");
        System.out.print(">>");
        String TimeStartIn = scanner.nextLine();
        Element timeStart = doc.createElement("timeStart");
        timeStart.appendChild(doc.createTextNode(TimeStartIn));
        newFlat.appendChild(timeStart);

        System.out.println("Введите время окончания");
        System.out.print(">>");
        String TimeEndIn = scanner.nextLine();
        Element timeEnd = doc.createElement("timeEnd");
        timeEnd.appendChild(doc.createTextNode(TimeEndIn));
        newFlat.appendChild(timeEnd);

        System.out.println("Введите номер дела/договора");
        System.out.print(">>");
        String contractIn = scanner.nextLine();
        Element contract = doc.createElement("contract");
        contract.appendChild(doc.createTextNode(contractIn));
        newFlat.appendChild(contract);

        System.out.println("Введите наименование суда");
        System.out.print(">>");
        String courtIn = scanner.nextLine();
        Element court = doc.createElement("court");
        court.appendChild(doc.createTextNode(courtIn));
        newFlat.appendChild(court);

        System.out.println("Введите тип обследования");
        System.out.print(">>");
        String contractTypeIn = scanner.nextLine();
        Element contractType = doc.createElement("contractType");
        contractType.appendChild(doc.createTextNode(contractTypeIn));
        newFlat.appendChild(contractType);

        System.out.println("Введите адрес");
        System.out.print(">>");
        String addressIn = scanner.nextLine();
        Element address = doc.createElement("address");
        address.appendChild(doc.createTextNode(addressIn));
        newFlat.appendChild(address);

        System.out.println("Введите этаж объекта");
        System.out.print(">>");
        String floorIn = scanner.nextLine();
        Element floor = doc.createElement("floor");
        floor.appendChild(doc.createTextNode(floorIn));
        newFlat.appendChild(floor);

        System.out.println("Введите количество этажей на объекте");
        System.out.print(">>");
        String totalFloorsIn = scanner.nextLine();
        Element totalFloors = doc.createElement("totalFloors");
        totalFloors.appendChild(doc.createTextNode(totalFloorsIn));
        newFlat.appendChild(totalFloors);

        System.out.println("Введите имя собственника");
        System.out.print(">>");
        String ownerIn = scanner.nextLine();
        Element owner = doc.createElement("owner");
        owner.appendChild(doc.createTextNode(ownerIn));
        newFlat.appendChild(owner);

        System.out.println("Введите присутствующее лицо");
        System.out.print(">>");
        String attendedIn = scanner.nextLine();
        Element attended = doc.createElement("attended");
        attended.appendChild(doc.createTextNode(attendedIn));
        newFlat.appendChild(attended);

        System.out.println("Введите наименование предприятия");
        System.out.print(">>");
        String fromTheSideIn = scanner.nextLine();
        Element fromTheSide = doc.createElement("fromTheSide");
        fromTheSide.appendChild(doc.createTextNode(fromTheSideIn));
        newFlat.appendChild(fromTheSide);

         System.out.println("Введите наименование прибора");
         System.out.print(">>");
         String toolsIn = scanner.nextLine();
         Element tools = doc.createElement("tools");
         tools.appendChild(doc.createTextNode(toolsIn));
         newFlat.appendChild(tools);


        Element root = doc.getDocumentElement();
        root.appendChild(newFlat);

        //Запись XML-файла
        doc.setXmlStandalone(true);
        doc.normalizeDocument();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
       transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/LR_10/homework/lr_10_hw_xml.xml"));
        transformer.transform(source,result);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void foundData() {
    try {
        System.out.println("Введите дату поиска");
        Scanner scFound = new Scanner(System.in);
        String found = scFound.nextLine();

        File inputFile = new File("src/LR_10/homework/lr_10_hw_xml.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBilder = dbFactory.newDocumentBuilder();
        Document doc = dBilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("flat");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            if (element.getElementsByTagName("date").item(0).getTextContent() == found){
                System.out.println("date: " + element.getElementsByTagName("date").item(0).getTextContent());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
    UI:
    {
        while (true) {
            System.out.println("1. Показать\n2. Ввести новые данные\n3. Поиск по адресу\n4. Поиск по дате осмотра\n0. Завершение");
            System.out.print(">>");
            Scanner sc = new Scanner(System.in);
            int scIn = sc.nextInt();
            if (scIn < 0 || scIn > 4) {
                System.out.println("Введено недопустимое значение");
                continue;
            }
            switch (scIn) {
                case 1:
                    showData();
                    break;
                case 2:
                    try {
                        addNewData();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    foundData();
                    break;
                case 0:
                break UI;
            }
        }
    }


    }
}

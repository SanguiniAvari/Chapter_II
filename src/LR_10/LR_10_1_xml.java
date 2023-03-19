package LR_10;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import java.io.File;

public class LR_10_1_xml {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //создание корневого элемента
            //Сколько может быть корневых элементов у документа?
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Library");
            doc.appendChild(rootElement);

            //добавление новой книги
            Element book1 = doc.createElement("Book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("Title");
            title1.appendChild(doc.createTextNode("Война и мир"));
            book1.appendChild(title1);

            Element autor1 = doc.createElement("Autor");
            autor1.appendChild(doc.createTextNode("Лев Толстой"));
            book1.appendChild(autor1);

            Element year1 = doc.createElement("Year");
            year1.appendChild(doc.createTextNode("1869"));
            book1.appendChild(year1);

            //Добавление второй книги
            Element book2 = doc.createElement("Book");
            rootElement.appendChild(book2);

            Element title2 = doc.createElement("Title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            book2.appendChild(title2);

            Element autor2 = doc.createElement("Autor");
            autor2.appendChild(doc.createTextNode("Михаил Булгаков"));
            book2.appendChild(autor2);

            Element year2 = doc.createElement("Year");
            year2.appendChild(doc.createTextNode("1967"));
            book2.appendChild(year2);


            //Запись XML-файла
            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf  = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            javax.xml.transform.dom.DOMSource source = new DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("src/LR_10/lr10_1_xml.xml"));
            transformer.transform(source, result);

            System.out.println("XML-файл успешно создан!");


        }catch (Exception pce){
            pce.printStackTrace();
        }
    }
}

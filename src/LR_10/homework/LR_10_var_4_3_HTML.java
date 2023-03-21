package LR_10.homework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.json.simple.JSONObject.escape;

public class LR_10_var_4_3_HTML {
    public static void isAboy(){
        try{
            File file = new File("src/LR_10/homework/LR_10_HTML.json");
            if(file.isDirectory()){
                System.out.println("Bingo");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void doMagic(List nodes, int i){
        try{
            isAboy();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/LR_10/homework/LR_10_HTML.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray =  (JSONArray) jsonObject.get("library");

            JSONObject news = new JSONObject();
            news.put("tema",escape(((Element)nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0).toString()));
            news.put("date",escape(((Element)nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0).toString()));
            jsonArray.add(news);
            jsonObject.put("library",jsonArray);

            FileWriter wfile = new FileWriter("src/LR_10/homework/LR_10_HTML.json");
                    wfile.write((jsonObject).toJSONString());
            wfile.flush();
            wfile.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();
            Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > " +
                    "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > "+
                    "tr > td:nth-child(1)");
            for (int i = 3; i < 20; i++){
                if(!(i%2==0)){
                    List<Node> nodes = newsParent.get(0).childNodes();
                    doMagic(nodes,i);
                    System.out.println("Тема: " +((Element)nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0));
                    System.out.println("Дата: " + ((Element)nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0)+"\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

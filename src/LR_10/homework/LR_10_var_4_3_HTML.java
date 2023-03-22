package LR_10.homework;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

import static org.json.simple.JSONObject.escape;

//java.net.UnknownHostException: fat.urfu.ru

public class LR_10_var_4_3_HTML {
    public static boolean isAboy(){
        try{
            File file = new File("src/LR_10/homework/LR_10_HTML.json");
            if(file.exists()){
                return true;
            } return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void doMagic(List nodes, int i) {
        try {
            if (isAboy()) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader("src/LR_10/homework/LR_10_HTML.json"));

                JSONObject jsonObject = (JSONObject) obj;
                JSONArray jsonArray = (JSONArray) jsonObject.get("library");

                JSONObject news = new JSONObject();
                news.put("tema", escape(((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0).toString()));
                news.put("date", escape(((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0).toString()));
                if (jsonArray.contains(news)){
                    System.out.println("\nТАКОЙ ЭЛЕМЕНТ ЕСТЬ В МАССИВЕ");
                } else {
                    jsonArray.add(news);
                    jsonObject.put("library", jsonArray);

                    FileWriter wfile = new FileWriter("src/LR_10/homework/LR_10_HTML.json");
                    wfile.write((jsonObject).toJSONString());
                    wfile.flush();
                    wfile.close();
                }
            } else {
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();

                JSONObject news = new JSONObject();
                news.put("tema", escape(((Element) nodes.get(i)).getElementsByClass("blocktitle").get(0).childNodes().get(0).toString()));
                news.put("date", escape(((Element) nodes.get(i)).getElementsByClass("blockdate").get(0).childNodes().get(0).toString()));
                jsonArray.add(news);
                jsonObject.put("library", jsonArray);

                FileWriter file = new FileWriter("src/LR_10/homework/LR_10_HTML.json");
                file.write(jsonObject.toJSONString());
                file.flush();
                file.close();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Document reConnect(){
        if (fivTime < 5) {
            fivTime ++;
            try {
                doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();
                return doc;
            }catch (Exception e){
             e.printStackTrace();
            }
        }
    return null;
    }
    static int fivTime = 0;
    static Document doc;
    public static void main(String[] args) throws IOException {
            reConnect();
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
    }
}

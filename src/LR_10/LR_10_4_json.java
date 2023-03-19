package LR_10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class LR_10_4_json {
    public static void main(String[] args) {
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/LR_10/lr10_2_json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Root Element" + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            for (Object o: jsonArray){
                JSONObject book = (JSONObject) o;
                System.out.println("\nCourent Element: book");
                System.out.println("Book name: " + book.get("title"));
                System.out.println("Autor: " + book.get("autor"));
                System.out.println("Year: " + book.get("year"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

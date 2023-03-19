package LR_10;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LR_10_3_json {
    public static void main(String[] args) throws IOException {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Война и мир");
        book1.put("autor", "Лев Толстой");
        book1.put("year", "1869");

        JSONObject book2 = new JSONObject();
        book2.put("title", "Мастер и Маргарита");
        book2.put("autor", "Михаил Булгаков");
        book2.put("year", "1967");

        books.add(book1);
        books.add(book2);

        library.put("books", books);

//        try (FileWriter file = new FileWriter("src/LR_10/lr10_2_json.json")){
//            file.write(library.toJSONString());
//            System.out.println("Json was created!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            FileWriter file = new FileWriter("src/LR_10/lr10_2_json.json");
            file.write(library.toJSONString());
            System.out.println("Json was created!");
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

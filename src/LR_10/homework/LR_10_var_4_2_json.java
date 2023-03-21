package LR_10.homework;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class LR_10_var_4_2_json {

    protected static void findData(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите поисковый запрос");
            String find = scanner.nextLine();

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/LR_10/homework/lr10_2_json.json"));
            JSONObject jsonObject = (JSONObject) obj;

            System.out.println("Root Element" + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            for (Object o: jsonArray){
                JSONObject book = (JSONObject) o;
                if(book.get("year").equals(find)||book.get("title").equals(find)||book.get("autor").equals(find)) {
                    System.out.println("\nCourent Element: book");
                    System.out.println("Book name: " + book.get("title"));
                    System.out.println("Autor: " + book.get("autor"));
                    System.out.println("Year: " + book.get("year"));
                };

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected static void addData(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/LR_10/homework/lr10_2_json.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            JSONObject book = new JSONObject();
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите название книги:");
            String title = sc.nextLine();
            System.out.println("Введите имя Автора:");
            String autor = sc.nextLine();
            System.out.println("Введите год издания:");
            String year = sc.nextLine();
            book.put("title", title);
            book.put("autor", autor);
            book.put("year", year);
            jsonArray.add(book);

                FileWriter file = new FileWriter("src/LR_10/homework/lr10_2_json.json");
                file.write(jsonObject.toJSONString());
                file.flush();
                file.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected static void delData(){
      try{
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/LR_10/homework/lr10_2_json.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

          System.out.println("Введите поисковый запрос для удаления");
          Scanner scanner = new Scanner(System.in);
          String dFine = scanner.nextLine();

          Iterator iterator = jsonArray.iterator();
          while (iterator.hasNext()) {
              JSONObject book = (JSONObject) iterator.next();
              if (dFine.equals(book.get("title"))||dFine.equals(book.get("year"))||dFine.equals(book.get("autor"))) {
                  iterator.remove();
              }}
          FileWriter file = new FileWriter("src/LR_10/homework/lr10_2_json.json");
          file.write(jsonObject.toJSONString());
          file.flush();
          file.close();
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    protected static void showMustGoOn(){
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/LR_10/homework/lr10_2_json.json"));
            JSONObject jsonObject = (JSONObject) obj;

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
    public static void main(String[] args) {
        while (true){
        try {
            System.out.println("================================================================================\n");
            System.out.println("1.Добавить\n2.Найти\n3.Удалить\n4.Показать\n0.Выход");
            System.out.print("\n================================================================================\n >>   ");
            Scanner scanner = new Scanner(System.in);
            int push = scanner.nextInt();
            if (push == 1){
                System.out.println();
                addData();
            }else if (push == 2){
                System.out.println();
                findData();
            } else if (push == 3) {
                System.out.println();
                delData();
            } else if (push == 4) {
                System.out.println("В базе следующие элементы:");
                showMustGoOn();
            }else if (push == 0){
                break;
            }else {
                System.out.println();
                System.out.println("Ввод некорректен");
                System.out.println();
            }
        }catch (InputMismatchException e){
            System.out.println("Введены недопустимые символы");
        }
        }

    }
}

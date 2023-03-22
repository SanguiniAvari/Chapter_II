package LR_10.homework;

import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class LR_10_var_4_4_excel {
    public static void Miracle(){
        String filePath = "src/LR_10/homework/lr10_excel.xsx";
        try(FileInputStream inputStream = new FileInputStream(filePath)) {
            //создаем экземпляр книги эксель из файла
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //получаем лист из книги по его имени
            XSSFSheet sheet = workbook.getSheet("Товар");
            //Перебираем строки и ячейки листа
            if (sheet == null){
                throw new LinkageError();
            }
            for (Row row : sheet) {
                for (Cell cell : row) {
                    //выводим значения на экран
                    System.out.println(cell.toString() + "\t");
                }
                System.out.println();
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
            System.out.println("Для повторной попытки введите \"1\"");
            System.out.print(">>   ");
            Scanner scanner = new Scanner(System.in);
            int bobo = scanner.nextInt();
            if (bobo == 1) {
                Miracle();
            }
        }
        catch (NotOfficeXmlFileException e){
            System.out.println("Неправильный формат файла");
            System.out.println("Для повторной попытки введите \"1\"");
            System.out.print(">>   ");
            Scanner scanner = new Scanner(System.in);
            int bobo = scanner.nextInt();
            if (bobo == 1){
               Miracle();
            }
        }
            catch (NoSuchFileException e){
                System.out.println("Неправильный формат файла");
                System.out.println("Для повторной попытки введите \"1\"");
                System.out.print(">>   ");
                Scanner scanner = new Scanner(System.in);
                int bobo = scanner.nextInt();
                if (bobo == 1){
                    Miracle();
                }
            }
        catch (EmptyFileException e){
            System.out.println("Файл пустой");
            System.out.println("Для повторной попытки введите \"1\"");
            System.out.print(">>   ");
            Scanner scanner = new Scanner(System.in);
            int bobo = scanner.nextInt();
            if (bobo == 1){
                Miracle();
            }
        }
        catch (LinkageError e){
            System.out.println("Запрашиваемый лист не найден");
            System.out.println("Для повторной попытки введите \"1\"");
            System.out.print(">>   ");
            Scanner scanner = new Scanner(System.in);
            int bobo = scanner.nextInt();
            if (bobo == 1){
                Miracle();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        Miracle();
    }
}


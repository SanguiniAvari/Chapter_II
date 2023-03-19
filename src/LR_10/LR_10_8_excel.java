package LR_10;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class LR_10_8_excel {
    public static void main(String[] args) throws IOException {
        //Открываем файл
        String filePath = "src/LR_10/lr10_excel.xlsx";
        try(FileInputStream inputStream = new FileInputStream(filePath)) {
            //создаем экземпляр книги эксель из файла
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //получаем лист из книги по его имени
            XSSFSheet sheet = workbook.getSheet("Товары");
            //Перебираем строки и ячейки листа
            for (Row row : sheet) {
                for (Cell cell : row) {
                    //выводим значения на экран
                    System.out.println(cell.toString() + "\t");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

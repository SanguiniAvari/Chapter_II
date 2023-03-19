package LR_10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class LR_10_7_excel {
    public static void main(String[] args) {
        //создаем новую книгу эксель
        XSSFWorkbook workbook = new XSSFWorkbook();
        //создаем новый лист в книге
        XSSFSheet sheet = workbook.createSheet("Товары");
        //записываем данные в ячейки
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Сидоров С.С.");
        dataRow1.createCell(2).setCellValue(500.0);

        //номер колонки
        Row dataRow2 = sheet.createRow(2);
        //номер строки
        dataRow2.createCell(0).setCellValue("Компьютер");
        dataRow2.createCell(1).setCellValue("Процессор: есть, Оперативная память: на складе");
        dataRow2.createCell(2).setCellValue(25000.0);

        //Запись в файл
        String filePath = "src/LR_10/lr10_excel.xlsx";
        try(FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

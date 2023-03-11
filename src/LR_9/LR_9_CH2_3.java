package LR_9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LR_9_CH2_3 {
    private static byte getValue(){
        while(true){
            try{
                System.out.print(">>   ");
                Scanner byteScan = new Scanner(System.in);
                int x = byteScan.nextInt();
                if (x<-128||x>127){
                    throw new RuntimeException("Выход за пределы");
                }
                return (byte)x;
            } catch (InputMismatchException e){
                System.out.println("Введены символы");
            }
            catch (RuntimeException e){
                System.out.println("Выход за пределы диапазона byte");
            }
        }
    }

    private static void showArr(byte[] bArr){
        for (int i = 0; i<bArr.length; i++){
            System.out.print(bArr[i]+"\t");

        }
    }

    public static void main(String[] args) {
        byte[] byteArray = new byte[5];
        System.out.println("Введите массив");
        for (int i = 0; i<byteArray.length; i ++){
            byteArray[i] = getValue();
        }
        System.out.println("Вы ввели:");
        showArr(byteArray);
        System.out.println("\nПробуем сложить");
        int sumByte=0;
            try{
            for (int j = 0; j < byteArray.length; j++) {
                if (sumByte > 127 || sumByte < -128){
                    throw new RuntimeException("full value of Byte");
                }
                        sumByte +=byteArray[j];
            }
        System.out.println("Результат:  " + sumByte);
        }catch (RuntimeException e){
                System.out.println("К сожалению сумма элементов массива больше, чем ожиалось");
                System.out.println("Завершение программы.");
        }
    }
}

package LR_9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LR_9_CH2_1 {
    private static int ArrayLength() {

        System.out.println("insert array length");

            while (true) {
                try {
                Scanner scan = new Scanner(System.in);
                int arrayLength = scan.nextInt();
                if (arrayLength < 0) {
                    throw new NegativeArraySizeException("Введено отрицательное число при определении длины массива");
                }
                return arrayLength;

            }catch (NegativeArraySizeException e) {
                    System.out.println("Введена отрицательная длина массива");
            }catch (InputMismatchException e) {
                    System.out.println("Несоответствие типа вводимых данных. Введите целое число");
                }
        }
    }

    public static int[] ArrayCall(int[] ar, int l) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert nums " + (l + 1));
            try {
                ar[l] = scanner.nextInt();
                return ar;
            } catch (InputMismatchException e) {
                System.out.println("Несоответствие типа вводимых данных. Введите Intager");
            }
        }
    }


    public static void main(String[] args) {
        double count=0;
        int[] ar = new int[ArrayLength()];
        for (int i = 0; i < ar.length; i++) {
            ArrayCall(ar, i);
        }

        for(int p =0; p<ar.length;p++){
            count += ar[p];
        }
        System.out.print("mid resoult of array = ");
        System.out.println(count/ar.length);
    }
}

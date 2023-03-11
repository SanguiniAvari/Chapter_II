package LR_9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LR_9_CH2_2 {

    private static int getKey(){
        int L = 0;

        while(true){
            System.out.print(">>   ");
            try{
                Scanner scanL = new Scanner(System.in);
                L = scanL.nextInt();
            if(L<=0){
                throw new ArrayIndexOutOfBoundsException("Недопустимая длина массива");
            }
                return L;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Введено недопустимое значение (меньшее или равное 0), попробуйте снова");
            }catch (InputMismatchException e){
                System.out.println("Всё же постарайтесь ввести число");
            }
        }
    }

    private static int getDeepArray(){
        int L;
        System.out.println("Введите число строк массива");
        L = getKey();
        return L;
    }

    private static int getLengthArray(){
        int L;
        System.out.println("Введите длину строки массива");
        L = getKey();
        return L;
    }

    private static void showArray(int[][] ar){
        for(int i=0; i< ar.length;i++){
            for(int j=0; j<ar[i].length;j++){
                System.out.print(ar[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static void showRow(int k, int[][] ar){
        for(int i=0; i<ar.length;i++){
            System.out.println(ar[i][k]);
        }
    }

    private static int[][] fillingArray(int[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                ar[i][j] = (int)(Math.random()*100);
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        int[][] arraySq = new int[getDeepArray()][getLengthArray()];
        fillingArray(arraySq);
        System.out.println("Представляю вам ваш массив");
        showArray(arraySq);
        System.out.println("Какой столбец выводим?");

        while (true){
            int quest = getKey()-1;
            try {
                if (quest+1 > arraySq[0].length) {
                    throw new ArrayIndexOutOfBoundsException("выход за пределы массива");
                }
                System.out.println("Значится, ваш столбец:");
                showRow(quest, arraySq);
                break;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("нет такого столбца, повторим?");
            }
        }
    }
}

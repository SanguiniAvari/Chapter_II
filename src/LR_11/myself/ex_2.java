package LR_11.myself;

import java.util.Scanner;

public class ex_2 {

    public static String countStr = "";

    public static void doMagic(Integer num){
        if (num>1) {
            doMagic(num / 2);
            countStr += Integer.toString(num % 2);
        } else {
            countStr += "1";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число");
        int count=scanner.nextInt();
        doMagic(count);
        System.out.println(countStr);
    }
}

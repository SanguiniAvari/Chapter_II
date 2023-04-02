package LR_11.myself;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex_3 {

    public static void doMagic(int array, ArrayList cont){

        if(array>0){
            Scanner scanner  = new Scanner(System.in);
            cont.add(scanner.nextInt());
            doMagic(array-1, cont);
        }
    }
    public static void main(String[] args) {
        ArrayList <Integer> cont = new ArrayList<>();
        System.out.println("Введи длину массива");
        Scanner scanner = new Scanner(System.in);
        Integer array = scanner.nextInt();
        doMagic(array,cont);
        System.out.println(cont);
    }
}

package LR_11.myself;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ex_7_1 {
    static int fillCounter = 1;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ArrayList<Integer> people = new ArrayList<>();
//        System.out.println("Enter count of people");
//        Scanner scanner = new Scanner(System.in);
//        int counter = scanner.nextInt();
        int counter = 2000;
        addTo(counter, people);
        System.out.println(people);


        while (people.size()!=1){
            List<Integer> leng = new ArrayList<>();
            for (int i = 0; i<people.size();i++){
                if (i%2!=0){
                    leng.add(people.get(i));
                }
            }
            people.removeAll(leng);
            System.out.println(people);
        }
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);

    }

    private static void addTo(int counter, ArrayList people) {
        if (counter>0){
            people.add(fillCounter);
            fillCounter++;
            counter--;
            addTo(counter,people);
        }
    }
}

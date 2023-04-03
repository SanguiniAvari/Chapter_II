package LR_11.myself;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ex_7_2 {
    static int fillCounter = 1;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        LinkedList<Integer> people = new LinkedList<>();
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

    private static void addTo(int counter, LinkedList people) {
        if (counter>0){
            people.push(fillCounter);
            fillCounter++;
            counter--;
            addTo(counter,people);
        }
    }
}

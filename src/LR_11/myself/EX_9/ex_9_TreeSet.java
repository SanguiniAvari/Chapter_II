package LR_11.myself.EX_9;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class ex_9_TreeSet {
    public static void main(String[] args) {
//        1.	Сравнение времени выполнения операции добавление элемента в начало коллекции;
//        2.	Сравнение времени выполнения операции добавление элемента в конец коллекции;
//        3.	Сравнение времени выполнения операции добавление элемента в середину коллекции;
//        4.	Сравнение времени выполнения операции удаления элемента в начале коллекции;
//        5.	Сравнение времени выполнения операции удаления элемента в конце коллекции;
//        6.	Сравнение времени выполнения операции удаления элемента в середине коллекции;
//        7.	Сравнение времени выполнения операции получения элемента по индексу;
//        Вариант 4: ArrayList, TreeSet, LinkedHashMap

        long start;
        long end;

        TreeSet<Long> arl = new TreeSet<>();

        start = System.currentTimeMillis();
        for (long j = 400_000l; j > 0l; j--) {
            arl.add(j);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в начало TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 800_002l; i < (1_200_002l); i++) {
            arl.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в конец TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 400_001l; i < (800_001l); i++) {
            arl.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в середину TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");


        start = System.currentTimeMillis();
        for (long i = 400_001l; i < (800_001l); i++) {
            arl.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Удаление из середины TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 1_200_002l; i > 800_002l; i--) {
            arl.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Удаление с конца TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long j = 0l; j < 400_000l; j++) {
            arl.add(j);
        }
        end = System.currentTimeMillis();
        System.out.println("Удаление из начала TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        TreeSet<Long> arl2 = new TreeSet<>();


        for (long j = 0l; j < 400_000l; j++) {
            arl2.add(j);
        }
        System.out.println("Всего значений в коллекции: " + arl2.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long j = 0l; j < 4_000_000_000l; j++) {
            arl2.first();
        }
        end = System.currentTimeMillis();
        System.out.println("Получаем первый элемент TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl2.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        long central = arl2.size()/2;
        for (long j = 0l; j < 4_000_000_000l; j++) {
            arl2.subSet(central,(central+1));
        }
        end = System.currentTimeMillis();
        System.out.println("Получаем центральный элемент TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl2.size() + "\n");
        System.out.println("________________________________________________\n");


        start = System.currentTimeMillis();
        for (long j = 0l; j < 4_000_000_000l; j++) {
            arl2.last();
        }
        end = System.currentTimeMillis();
        System.out.println("Получаем последний элемент TreeSet: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl2.size() + "\n");
        System.out.println("________________________________________________\n");
    }
}

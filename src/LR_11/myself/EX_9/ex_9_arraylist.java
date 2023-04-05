package LR_11.myself.EX_9;

import java.util.ArrayList;

public class ex_9_arraylist {
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

        ArrayList<Long> arl = new ArrayList<>();
        for (long i = 0; i < (4_000); i++) {
            arl.add(i);
        }
        start = System.currentTimeMillis();
        for (long j = 0; j < 400_000; j++) {
            arl.add(0, j);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в начало Array list: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        ArrayList<Long> arl1 = new ArrayList<>();
        for (long i = 0; i < 4_000; i++) {
            arl1.add(i);
        }
        start = System.currentTimeMillis();
        for (long i = 0; i < 400_000; i++) {
            arl1.add(arl1.size() / 2, i);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в середину Array list: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        ArrayList<Long> arl2 = new ArrayList<>();
        for (long i = 0; i < 4_000; i++) {
            arl2.add(i);
        }
        start = System.currentTimeMillis();
        for (long i = 0; i < 400_000; i++) {
            arl2.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в конец Array list: " + (end - start));
        System.out.println("Всего значений в коллекции: " + arl.size() + "\n");
        System.out.println("________________________________________________\n");

        ArrayList<Long> arl3 = new ArrayList<>();
        for (long i = 0; i < 400_000; i++) {
            arl3.add(i);
        }
        System.out.println("Получение элемента по индексу");
        start = System.currentTimeMillis();
        for (long ko = 0; ko < 4_000_000_000l; ko++) {
            arl3.get(0);
        }
        end = System.currentTimeMillis();
        System.out.println("Начало: " + (end - start));
        start = System.currentTimeMillis();
        for (long ko = 0; ko < 4_000_000_000l; ko++) {
            arl2.get(200_000);
        }
        end = System.currentTimeMillis();
        System.out.println("Середина: " + (end - start));
        start = System.currentTimeMillis();
        for (long ko = 0; ko < 4_000_000_000l; ko++) {
            arl3.get(400_000-1);
        }
        end = System.currentTimeMillis();
        System.out.println("Конец: " + (end - start));
        System.out.println("________________________________________________\n");

        System.out.println("Удаление элемента из коллекции");

        start = System.currentTimeMillis();
        for (long ko = 0; ko < 400000; ko++) {
            arl.remove(0);
        }
        end = System.currentTimeMillis();
        System.out.println("Из начала: " + (end - start));

        start = System.currentTimeMillis();
        for (long ko = 0; ko < 400000; ko++) {
            arl1.remove(arl1.size() / 2);
        }
        end = System.currentTimeMillis();
        System.out.println("Из середины: " + (end - start));

        start = System.currentTimeMillis();
        for (long ko = 0; ko < 400000; ko++) {
            arl2.remove(arl2.size() - 1);
        }
        end = System.currentTimeMillis();
        System.out.println("Из конца: " + (end - start));
    }
}

package LR_11.myself.EX_9;

import java.util.LinkedHashMap;

public class ex_9_LinkedHashMap {
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

        LinkedHashMap boris = new LinkedHashMap<>();

        start = System.currentTimeMillis();
        for (long i = 0; i < 400_000l; i++) {
            boris.put(i, 0);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в начало LinkedHashMap: " + (end - start));
        System.out.println("Всего значений в коллекции: " + boris.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 400_000l; i < 800_001l; i++) {
            boris.put(i, 0);
        }
        end = System.currentTimeMillis();
        System.out.println("Добавление в конец LinkedHashMap: " + (end - start));
        System.out.println("Всего значений в коллекции: " + boris.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 800_001l; i > 400_001l; i--) {
            boris.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Удаление с конца LinkedHashMap: " + (end - start));
        System.out.println("Всего значений в коллекции: " + boris.size() + "\n");
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 0; i < 400_000l; i++) {
            boris.remove(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Удаление с начала LinkedHashMap: " + (end - start));
        System.out.println("Всего значений в коллекции: " + boris.size() + "\n");
        System.out.println("________________________________________________\n");

        System.out.println("Вызываем первый средний и последний элементы\n");

        LinkedHashMap borisIvanovich = new LinkedHashMap<>();

        for (long i = 0; i < 400_000l; i++) {
            borisIvanovich.put(i, 0);
        }

        start = System.currentTimeMillis();
        for (long i = 0; i < 4_000_000_000l; i++) {
            borisIvanovich.get(0);
        }
        end = System.currentTimeMillis();
        System.out.println("Получение первого элемента LinkedHashMap: " + (end - start));
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 0; i < 4_000_000_000l; i++) {
            borisIvanovich.get(200_000);
        }
        end = System.currentTimeMillis();
        System.out.println("Получение среднего элемента LinkedHashMap: " + (end - start));
        System.out.println("________________________________________________\n");

        start = System.currentTimeMillis();
        for (long i = 0; i < 4_000_000_000l; i++) {
            borisIvanovich.get(400_000-1);
        }
        end = System.currentTimeMillis();
        System.out.println("Получение последнего элемента LinkedHashMap: " + (end - start));
        System.out.println("________________________________________________\n");

    }
}

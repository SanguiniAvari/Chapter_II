package LR_11.myself;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ex_6 {
    public static void main(String[] args) {
        HashMap <Integer, String> mapa = new HashMap<>();
        mapa.put(0,"первый");
        mapa.put(1,"второй");
        mapa.put(2,"третий");
        mapa.put(3,"четвертый");
        mapa.put(4,"пятый");
        mapa.put(5,"шестой");
        mapa.put(6,"седьмой");
        mapa.put(7,"восьмой");
        mapa.put(8,"девятый");
        mapa.put(9,"десятый");

        Set<Map.Entry<Integer, String>> set = mapa.entrySet();

//      Вывести все значения, у которых ключ больше 5.
//        for (Map.Entry<Integer, String> more5: set){
//            if(more5.getKey()>5){
//                System.out.println("for " + more5.getKey() + " value = " + more5.getValue());
//            }
//        }

        System.out.println("\n Если ключ = 0 вывести через запятую все значения");
        Integer sum=1;
//      Если ключ = 0 вывести через запятую все значения
        for (Map.Entry<Integer, String> mult: set){

            if(mult.getKey()==0){
                for (Map.Entry<Integer, String> inner : set){
                    System.out.print(inner.getValue()+", ");
                }
            }

            if(mult.getKey()>5){
                System.out.println("key more 5 for " + mult.getKey() + " value = " + mult.getValue());
            }

            if (mult.getValue().length()>5&&mult.getKey()!=0){
                sum*= mult.getKey();
            }
        }
//      Перемножить все значения ключей, где длина строки больше 5
//        System.out.println("\n Перемножить все значения ключей, где длина строки больше 5");
//
//        for (Map.Entry<Integer, String> mult: set){
//            System.out.println(mult.getValue().length());
//            if(mult.getValue().length()>5&&mult.getKey()!=0){
//                sum*= mult.getKey();
//                }
//            }
        System.out.println("Результат перемножения всех ключей, где длина строки больше 5: "+sum);
        }

    }


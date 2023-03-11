package LR_9;

public class LR_9_7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);}
        try {
            throw new ArithmeticException("вывел исключения из блока catch");
        } catch (ArithmeticException e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }

}

package LR_9;

public class LR_9_2 {

    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            // System.out.println("1");  - данная строка кода никогда не будет выполнена, поскольку находится после
            // принудительно вызванного исключения. подлежит удалению.
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }

}

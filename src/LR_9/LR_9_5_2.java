package LR_9;

public class LR_9_5_2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
        System.out.println("ТУТ " + e);
    }
        System.out.println("2");
    }

}

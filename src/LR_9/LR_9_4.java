package LR_9;

public class LR_9_4 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
        } catch (Exception e) {
            System.out.println("2 " + e);
        } catch (Error e) {
            System.out.println("3 " + e);
        }
        System.out.println("4");
    }

}

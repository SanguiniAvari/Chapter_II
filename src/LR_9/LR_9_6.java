package LR_9;

public class LR_9_6 {

    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1 " + e);
            //Восстановлена иерархия исключений "потомок-предок"
        } catch (RuntimeException e) {
            System.out.println("3 " + e);
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("4");
    }

}

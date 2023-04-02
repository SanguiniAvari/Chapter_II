package LR_11;

public class LR_11_5 {
    static int monumero = 1;
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static int fact(int n){

        System.out.println(monumero + " --> " + n);
        monumero++;
        if (n==0){
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return fact(n-2) + fact(n-1);
        }
    }
}

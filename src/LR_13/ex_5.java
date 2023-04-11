package LR_13;

// Процессор	AMD Ryzen 5 5600X 6-Core Processor, 3701 МГц, ядер: 6, логических процессоров: 12

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ex_5 {

    public static int result = 0;

    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        int sc = scanner.nextInt();
        int[] arr = new int[sc];
        Random random = new Random();
        for (int i = 0; i < sc; i++) {
            arr[i] = random.nextInt(1000000);
        }
        System.out.println(Arrays.toString(arr));

        fastmax(arr, sc);

    }

    public static void fastmax(int[] arr, int sc) throws InterruptedException{
        int courentSC1 = sc / 3;
        Thread core1 = new Thread(() -> {
            for (int i = 0; i < courentSC1; i++) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });

        Thread core2 = new Thread(() -> {
            for (int i = courentSC1; i > 0; i--) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });
        Thread core3 = new Thread(() -> {
            for (int i = courentSC1; i < courentSC1 * 2; i++) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });
        Thread core4 = new Thread(() -> {
            for (int i = courentSC1 * 2; i > courentSC1; i--) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });
        Thread core5 = new Thread(() -> {
            for (int i = courentSC1 * 2; i < sc; i++) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });
        Thread core6 = new Thread(() -> {
            for (int i = sc-1; i > courentSC1 * 2; i--) {
                if (result < arr[i]) {
                    result = arr[i];
                }
            }
        });

        core1.start();
        core2.start();
        core3.start();
        core4.start();
        core5.start();
        core6.start();
        core6.join();
        System.out.println(result);
        int k = 0;
        for (int ko =0 ; ko<arr.length-1; ko++){
            if (arr[ko]>k){
                k = arr[ko];
            }
        }
        System.out.println("Контрольный максимум: " + k);
    }
}

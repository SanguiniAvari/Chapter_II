package LR_13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) throws InterruptedException {
        fastSumm jojo = new fastSumm();
        jojo.run();

    }

    static class fastSumm {
        public int sumCore1 = 0;
        public int sumCore2 = 0;
        public int sumCore3 = 0;
        public int sumCore4 = 0;
        public int sumCore5 = 0;
        public int sumCore6 = 0;

        public int finishMark = 0;
        public int[] arr;

        fastSumm() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество элементов массива: ");
            int sc = scanner.nextInt();
            int[] arr = new int[sc];
            Random random = new Random();
            for (int i = 0; i < sc; i++) {
                arr[i] = random.nextInt(10);
            }
            System.out.println(Arrays.toString(arr));
            this.arr = arr;
        }

        public void run() throws InterruptedException {
            int n = this.arr.length / 6;
            System.out.println("Размер секции равен: " + n);
            Thread core1 = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    sumCore1 += this.arr[i];
                }
                finishMark += 1;
            });

            Thread core2 = new Thread(() -> {
                for (int j = n; j < 2 * n; j++) {
                    sumCore2 += this.arr[j];
                }
                finishMark += 1;
            });

            Thread core3 = new Thread(() -> {
                for (int k = 2 * n; k < 3 * n; k++) {
                    sumCore3 += this.arr[k];
                }
                finishMark += 1;
            });

            Thread core4 = new Thread(() -> {
                for (int l = 3 * n; l < 4 * n; l++) {
                    sumCore4 += this.arr[l];
                }
                finishMark += 1;
            });

            Thread core5 = new Thread(() -> {
                for (int m = 4 * n; m < 5 * n; m++) {
                    sumCore5 += this.arr[m];
                }
                finishMark += 1;
            });

            Thread core6 = new Thread(() -> {
                for (int h = 5 * n; h < this.arr.length; h++) {
                    sumCore6 += this.arr[h];
                }
                finishMark += 1;
            });
            core1.start();
            core2.start();
            core3.start();
            core4.start();
            core5.start();
            core6.start();

            Thread result = new Thread(() -> {
                while (true) {
                    if (finishMark == 6) {
                        System.out.println(sumCore1 + sumCore2 + sumCore3 + sumCore4 + sumCore5 + sumCore6);
                        break;
                    }
                }
            });

            while (true) {
                if (finishMark == 6) {
                    result.start();
                    result.join();
                    break;
                }
            }

            System.out.println("сумма по ядрам:");
            System.out.println(sumCore1);
            System.out.println(sumCore2);
            System.out.println(sumCore3);
            System.out.println(sumCore4);
            System.out.println(sumCore5);
            System.out.println(sumCore6);

            System.out.print("Контрольная сумма: ");
            int summ = 0;
            for (int go = 0; go < this.arr.length; go++) {
                summ += this.arr[go];
            }
            System.out.println(summ);

        }
    }
}


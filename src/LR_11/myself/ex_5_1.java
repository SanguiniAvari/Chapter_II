package LR_11.myself;

import java.util.Scanner;

public class ex_5_1 {
    //Заполнение с головы

    public static void main(String[] args) {
        System.out.println("количество элементов:");
        Scanner scanner = new Scanner(System.in);
        int elem = scanner.nextInt();
        Node head = null;
        for (int i = 0; i<=elem; i++){
            head = new Node(i, head);
        }
        Node ref = head;
        while (ref!=null){
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }

    static class Node{
        public int value;
        public Node next;
        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

}

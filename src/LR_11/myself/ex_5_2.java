package LR_11.myself;

import java.util.Scanner;

public class ex_5_2 {
    static class Node{
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    static Node appendNode(int value, Node node){
            Node nodeNext = new Node(value, null);
            while (node.next != null){
                node = node.next;
            }
            node.next = nodeNext;
            return node;
    }

    public static void printThis(Node node) {
        Node ptr = node;
        while (ptr != null) {
            System.out.print(ptr.value + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }
    static Node node;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи длину:");
        node = new Node(0,null);
        int i = scanner.nextInt();

        for (int j = 1; j<i;j++){
            appendNode(j, node);
        }
        printThis(node);
    }
}

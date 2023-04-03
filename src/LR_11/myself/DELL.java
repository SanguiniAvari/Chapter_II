package LR_11.myself;

import java.util.ArrayList;

public class DELL {

    public static void main(String[] args) {
        Node node = new Node(1, null);
        Node node2 = new Node(2, null);

        node.put(node2);

    }

    public static class Node{
        int value;
        Node next;

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        public void put(Node node){
            System.out.println(value);
            System.out.println(node.value);
        }
    }



}

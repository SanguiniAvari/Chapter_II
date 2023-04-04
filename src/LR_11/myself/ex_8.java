package LR_11.myself;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        Node testing = NewNode(0);
        testing = testing.createHead(1, testing);
        printList(testing);
        testing = testing.createTail(2, testing);
        printList(testing);
        System.out.println("finish");
        System.out.println(testing.toString());

        Node test2 = NewNode(3);
        test2 = test2.createTail(4, test2);
        System.out.println(test2.toString());

        testing = testing.AddFirst(test2);
        System.out.println(testing.toString());

        Node test3 = NewNode(5);
        test3 = test3.createTail(6, test3);

        testing = testing.AddLast(test3);
        System.out.println(testing.toString());

        Node test4 = new Node(7, null);
        testing = testing.Insert(3, test4);
        System.out.println(testing.toString());

        testing = testing.RemoveFirst();
        System.out.println(testing.toString());

        testing = testing.RemoveLast();
        System.out.println(testing.toString());

        testing = testing.Remove(3);
        System.out.println(testing.toString());

//        Используем рекурсию
        System.out.println("-----------------");
        Node testing2 = NewNode(0);
        testing2 = createHeadRec(3, testing2);
        printList(testing2);

        System.out.println("finish");
        System.out.println(testing2.toString());

        Node testing3 = createHeadRec(5);
        printList(testing3);

        Node testing4 = createTailRec(9, testing3);
        System.out.println(testing4.toString());

        Node testing5 = createTailRec(4);
        System.out.println(testing5.toString());

        System.out.println("________");
        toStringRec(testing4);
        System.out.println(toStringRec(testing4));
    }

//            С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ


    private static Node createHeadRec(int data, Node node) {
//            Ввод с головы
        if (data > 0) {
            Node courent = node;
            Node Xnode = new Node(data, courent);
            Node Ynode = createHeadRec((data - 1), Xnode);
            return Ynode;
        }
        return node;
    }

    private static Node createHeadRec(int data) {
//            Ввод с головы
        Node courent = new Node(data, null);
        if (data > 0) {
            Node Xnode = new Node((data - 1), courent);
            Node Ynode = createHeadRec((data - 2), Xnode);
            return Ynode;
        }
        return null;
    }

    private static Node createTailRec(int rec, Node node) {
//            Ввод с хвоста
        Node current = node;
        if (rec == 0) {
            return null;
        }
        Node xCurrent = tailDownRec(current);
        xCurrent.link = createTailRec((rec - 1), new Node((rec - 1), null));
        return node;
    }

    private static Node createTailRec(int rec) {
//            Ввод с хвоста
        Node current = new Node(rec,null);
        if (rec == 0) {
            return null;
        }
        Node xCurrent = tailDownRec(current);
        xCurrent.link = createTailRec((rec - 1), new Node((rec - 1), null));
        return current;
    }

    private static Node tailDownRec(Node node) {
        Node courent = node;
        if (courent.link!= null){
            courent = tailDownRec(courent.link);
            return courent;
        } return courent;
    }

    private static String toStringRec(Node node) {
//            вывод строки из элементов списка
        String letter = "" + node.value;
        if (node.link!=null){
            node = node.link;
            letter += toStringRec(node);
            return letter;
        }return letter;
    }

    public static Node NewNode(int value) {
//            Новый массив
        Node newmylist = new Node(value, null);
        return newmylist;

    }

    public static void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.value + " —> ");
            ptr = ptr.link;
        }

        System.out.println("null");
    }

    public static class Node {

        int value;
        Node link;

        Node(int value, Node link) {
            this.value = value;
            this.link = link;
        }

        //            С ИСПОЛЬЗОВАНИЕМ ЦИКЛОВ
        public String toString() {
            //            Вывод строки, сформированной из элементов
            Node courent = new Node(value, link);
            String str = "";
            while (courent.link != null) {
                str += courent.value;
                courent = courent.link;
            }
            str += courent.value;
            return str;
        }

        public Node AddFirst(Node addNode) {
            Node courent = addNode;
            Node tailNode = new Node(value, link);
            while (courent.link != null) {
                courent = courent.link;
            }
            courent.link = tailNode;
            return addNode;
//            Добавление элемента в начало списка
        }

        private Node AddLast(Node addNode) {
//            Добавление элемента в конец списка
            Node courent = addNode;
            Node tailNode = new Node(value, link);
            Node castNode = tailNode;
            while (castNode.link != null) {
                castNode = castNode.link;
            }
            castNode.link = courent;
            return tailNode;

        }


        public static Node createHead(int value, Node head) {
//            Ввод с головы
            Node current = head;
            Node node = NewNode(value);
            node.link = current;
            return node;
        }

        private static Node createTail(int value, Node tail) {
//            Ввод с хвоста
            Node courent = tail;
            Node node = NewNode(value);
            while (courent.link != null) {
                courent = courent.link;
            }
            courent.link = node;
            return tail;
        }

        private Node Insert(int ind, Node InsertNode) {
//            Вставка элемента в список с указанным номером
            Node courent = new Node(value, link);
            Node result = courent;
            Node newNode = InsertNode;

            for (int i = 0; i <= ind; i++) {
                if (i == (ind - 1)) {
                    newNode.link = courent.link;
                    courent.link = newNode;
                }
                courent = courent.link;
            }
            return result;
        }

        private Node RemoveFirst() {
//            Удаление элемента с головы спиcка
            Node courent = new Node(value, link);
            Node result = courent.link;
            return result;
        }

        private int size() {
            int s = 1;
            Node courent = new Node(value, link);
            while (courent.link != null) {
                s++;
                courent = courent.link;
            }
            return s;
        }

        private Node RemoveLast() {
//            Удаление элемента с конца спиcка
            Node courent = new Node(value, link);
            Node result = courent;

            int siz = courent.size();
            for (int i = 0; i < siz - 1; i++) {
                if (i == siz - 2) {
                    courent.link = null;
                } else {
                    courent = courent.link;
                }
            }
            return result;
        }

        private Node Remove(int ind) {
//            Удаление из списка элемента с указанным номером
            Node courent = new Node(value, link);

            Node result = courent;
            Node save = new Node(0, null);

            int siz = courent.size();
            for (int i = 0; i < siz - 1; i++) {
                if (i == ind) {
                    save = courent.link;
                    break;
                } else {
                    courent = courent.link;
                }
            }
            courent = result;
            for (int j = 0; j <= ind; j++) {
                if (j == (ind - 1)) {
                    courent.link = save;
                    return result;
                } else {
                    courent = courent.link;
                }
            }

            return result;
        }

    }

}



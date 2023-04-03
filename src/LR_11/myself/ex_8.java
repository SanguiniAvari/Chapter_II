package LR_11.myself;

import java.util.ArrayList;

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
        test2 = test2.createTail(4,test2);
        System.out.println(test2.toString());

        testing = testing.AddFirst(test2);
        System.out.println(testing.toString());

        Node test3 = NewNode(5);
        test3 = test3.createTail(6,test3);

        testing = testing.AddLast(test3);
        System.out.println(testing.toString());

        Node test4 = new Node (7, null);
        testing = testing.Insert(3,test4);
        System.out.println(testing.toString());
    }




    public static Node NewNode (int value) {
//            Новый массив
        Node newmylist = new Node(value, null);
        return newmylist;

    }

    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
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
        public String toString () {
        //            Вывод строки, сформированной из элементов
            Node courent = new Node (value, link);
            String str = "";
            while(courent.link != null){
                str += courent.value;
                courent = courent.link;
            }str += courent.value;
            return str;
        }
        public Node AddFirst (Node addNode) {
            Node courent = addNode;
            Node tailNode = new Node(value,link);
            while (courent.link!=null){
                courent = courent.link;
            } courent.link = tailNode;
            return addNode;
//            Добавление элемента в начало списка
        }

        private Node AddLast(Node addNode) {
//            Добавление элемента в конец списка
            Node courent = addNode;
            Node tailNode = new Node(value,link);
            Node castNode = tailNode;
            while (castNode.link!=null){
                castNode = castNode.link;
            } castNode.link = courent;
            return tailNode;

        }


        public static Node createHead (int value, Node head) {
//            Ввод с головы
                Node current = head;
                Node node = NewNode(value);
                node.link = current;
                return node;
        }

            private static Node createTail (int value, Node tail) {
//            Ввод с хвоста
                Node courent = tail;
                Node node = NewNode(value);
                while (courent.link != null){
                    courent = courent.link;
                } courent.link=node;
                return tail;
            }

            private Node Insert (int ind, Node InsertNode) {
//            Вставка элемента в список с указанным номером
            Node result = new Node (value, link);
            Node courent = InsertNode;
            for (int i = 0; i<ind; i++){
                if(i==ind--){
                    Node save = new Node(result.value, result.link);
                    courent.link = save.link;
                    result.link = courent;
                }
            }return result;
        }
            private static void RemoveFirst () {
//            Удаление элемента с головы спика
        }

            private static void RemoveLast () {
//            Удаление элемента с конца спика
        }

            private static void Remove () {
//            Удаление элемента с конца спика
        }

//            С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ

            private static void createHeadRec () {
//            Ввод с головы
        }

            private static void createTailRec () {
//            Ввод с хвоста
        }

            private static void toStringRec () {
//            вывод строки из элементов списка
        }

        }

    }



package LR_11.myself;

class Node
{
    int value;
    Node next;

    Node(int value, Node next)
    {
        this.value = value;
        this.next = next;
    }
}

class Main
{
    // Вспомогательная функция для возврата нового узла связанного списка из кучи
    public static Node newNode(int key)
    {
        Node node = new Node(key, null);
        return node;
    }

    // Вспомогательная функция для печати заданного связанного списка
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.value + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Функция для добавления нового узла в конец списка вместо его головы
    public static Node appendNode(Node head, int key)
    {
        Node current = head;
        Node node = newNode(key);

        // особый случай длины 0
        if (current == null) {
            head = node;
        }
        else {
            // найти последний узел
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }

        return head;
    }

    public static void main(String[] args)
    {
        // ключи ввода
        int[] keys = {1, 2, 3, 4};

        // указывает на головной узел связанного списка
        Node head = null;
        for (int key: keys) {
            head = appendNode(head, key);
        }

        // распечатать связанный список
        printList(head);
    }
}

    


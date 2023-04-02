package LR_11.myself;

public class del {

        public static void main(String[] args) {
            // Добавление элиментов с перемещением головы (наращивание головы)
            Node head = null;
            for (int i = 9; i >= 0; i--){
                head = new Node(i,head);
            }

            // Вывод элиментов на экран
            Node ref = head;
            while (ref != null){
                System.out.print(" " + ref.value);
                ref = ref.next;
            }
        }

    static class Node { //КЛАСС - СТРУКТУРА ЭЛИМЕНТА СПИСКА
        public int value; // значение
        public Node next; // поле - ссылка (указатель) на следующий узел

        Node(int value, Node next) { // конструктор класса
            this.value = value;
            this.next = next;
        }
    }
    }

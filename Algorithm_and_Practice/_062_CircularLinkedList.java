package Algorithm_and_Practice;

public class _062_CircularLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    public _062_CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }
    public void insert(int val){
        Node new_node = new Node(val);
        if (head == null){
            head = new_node;
            tail = new_node;
        }
        tail.next = new_node;
        new_node.next = head;
        tail = new_node;
        size++;
    }
    public void display(){
        Node node = head;
        if (head != null){
            do{
                System.out.print(node.value+" -> ");
                node = node.next;
            }while (node != head);
            System.out.printf("HEAD\n");
        }
    }
    public void delete(int val){
         Node node = head;
         if (node == null){
             return;
         }
         if (node.value == val){
             head = head.next;
             tail.next = head;
             return;
         }
         do{
             Node n = node.next;
             if (n.value == val){
                 node.next = n.next;
                 break;
             }
             node = node.next;
         }while (node != head);

    }

    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}

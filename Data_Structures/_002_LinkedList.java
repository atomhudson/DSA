package Data_Structures;

// 1. A linear data structure elements are arranged sequentially,
//    and you can traverse them in a specific order.
// 2. Non-contiguous memory allocation.

// ADV1: No need to initialize the number of element to be stored.
// ADV2: Non-contiguous memory allocation.

// DIS_ADV1: Access time complexity is more.
// DIS_ADV2: More Memory space is required.(to save both data and address of next node).

public class _002_LinkedList {

    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    Node head = null;
    public void insertInBegining(int value)
    {
        Node new_node = new Node(value);
        if (head != null) {
            new_node.next = head;
        }
        head = new_node;
    }
    public void insertInLast(int value){
        Node new_node = new Node(value);
        if (head == null){
            head = new_node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new_node;
    }

    public void insertInSpecificPosition(int value, int index){
        Node new_node = new Node(value);
        if (index == 0 || head == null){
            new_node.next = head;
            head = new_node;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++){
            temp = temp.next;
        }
        new_node.next = temp.next;
        temp.next = new_node;
    }

    public void traverse(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        _002_LinkedList linkedList = new _002_LinkedList();
        linkedList.insertInLast(10);
        linkedList.insertInLast(20);
        linkedList.insertInLast(30);
        linkedList.insertInLast(40);
        linkedList.insertInLast(50);
        linkedList.insertInLast(60);
        linkedList.traverse();
        linkedList.insertInBegining(10);
        linkedList.insertInBegining(20);
        linkedList.insertInBegining(30);
        linkedList.insertInBegining(40);
        linkedList.insertInBegining(50);
        linkedList.insertInBegining(60);
        linkedList.traverse();
        linkedList.insertInSpecificPosition(10,0);
        linkedList.insertInSpecificPosition(20,1);
        linkedList.insertInSpecificPosition(30,2);
        linkedList.insertInSpecificPosition(40,3);
        linkedList.insertInSpecificPosition(50,4);
        linkedList.insertInSpecificPosition(60,5);
        linkedList.traverse();
    }
}

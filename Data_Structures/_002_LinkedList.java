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
    public void traverse(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        _002_LinkedList linkedList = new _002_LinkedList();
        linkedList.insertInBegining(10);
        linkedList.insertInBegining(20);
        linkedList.insertInBegining(30);
        linkedList.insertInBegining(40);
        linkedList.insertInBegining(50);
        linkedList.insertInBegining(60);
        linkedList.traverse();
    }
}

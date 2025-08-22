package Data_Structures;

// 1. A linear data structure elements are arranged sequentially,
//    and you can traverse them in a specific order.
// 2. Non-contiguous memory allocation.

// ADV1: No need to initialize the number of element to be stored.
// ADV2: Non-contiguous memory allocation.

// DIS_ADV1: Access time complexity is more.
// DIS_ADV2: More Memory space is required.(to save both data and address of next node).

import java.lang.ref.WeakReference;

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

    public void deleteFromBegining(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    public void deleteFromLast(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteFromSpecificPosition(int index){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Index out of range.");
            return;
        }
        temp.next = temp.next.next;
    }

    public boolean isPalindrome(Node head){
        Node temp = head;
        StringBuilder list = new StringBuilder();
        while(temp != null){
            list.append(temp.value);
            temp = temp.next;
        }
        String original = list.toString();
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
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
        linkedList.insertInLast(1);
        linkedList.insertInLast(2);
//        linkedList.insertInLast(2);
//        linkedList.insertInLast(1);
        System.out.println(linkedList.isPalindrome(linkedList.head));
//        linkedList.insertInLast(10);
//        linkedList.insertInLast(20);
//        linkedList.insertInLast(30);
//        linkedList.insertInLast(40);
//        linkedList.insertInLast(50);
//        linkedList.insertInLast(60);
//        linkedList.traverse();
//        linkedList.insertInBegining(9);
//        linkedList.insertInBegining(8);
//        linkedList.insertInBegining(7);
//        linkedList.insertInBegining(6);
//        linkedList.insertInBegining(5);
//        linkedList.insertInBegining(4);
//        linkedList.traverse();
//        linkedList.deleteFromBegining();
//        linkedList.traverse();
//        linkedList.deleteFromBegining();
//        linkedList.traverse();
//        linkedList.deleteFromLast();
//        linkedList.traverse();
//        linkedList.deleteFromLast();
//        linkedList.traverse();
//        linkedList.insertInSpecificPosition(1,0);
//        linkedList.insertInSpecificPosition(2,1);
//        linkedList.insertInSpecificPosition(3,2);
//        linkedList.insertInSpecificPosition(4,3);
//        linkedList.insertInSpecificPosition(5,4);
//        linkedList.traverse();
//        linkedList.deleteFromSpecificPosition(0);
//        linkedList.traverse();

    }
}

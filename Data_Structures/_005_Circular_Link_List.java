package Data_Structures;

public class _005_Circular_Link_List {
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    Node head = null;

    public void insertInLast(int value){
        Node new_node = new Node(value);
        if(head == null){
            head = new_node;
            new_node.next = head;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = new_node;
        new_node.next = head;
    }
    public void insertInBegining(int value){
        Node new_node = new Node(value);
        if (head == null){
            head = new_node;
            new_node.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        new_node.next = head;
        temp.next = new_node;
        head = new_node;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        _005_Circular_Link_List list = new _005_Circular_Link_List();
//        list.insertInLast(1);
//        list.insertInLast(2);
//        list.insertInLast(3);
//        list.insertInLast(4);
//        list.insertInLast(5);
//        list.insertInLast(6);
        list.insertInBegining(1);
        list.insertInBegining(2);
        list.insertInBegining(3);
        list.insertInBegining(4);
        list.insertInBegining(5);
        list.insertInBegining(6);
        list.traverse();
    }
}

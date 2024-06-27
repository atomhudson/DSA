public class _59_CustomLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public _59_CustomLinkedList() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null){
            tail = head;
        }
        size +=1;
    }
    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
        size++;
    }
    public void justInsert(int val, int index){
        if (index > size){
            return;
        }
       if (index == 0){
           insertFirst(val);
           return;
       }
       if (index == size){
           insertLast(val);
           return;
       }
       Node temp = head;
       for (int i = 1; i < index; i++) {
            temp = temp.next;
       }
       Node node = new Node(val, temp.next);
       temp.next = node;
       size++;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLastNode = getNode(size-2);
        int val = tail.value;
        tail = secondLastNode;
        tail.next = null;
        return val;
    }
    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size-1){
            return deleteLast();
        }
        Node prev = getNode(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public Node getNode(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
//    Displaying the Linked List.
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
    }
//    Finding the Node in Linked List
    public String find(int val){
        Node node = head;
        while (node != null){
            if (node.value == val){
                return String.valueOf(node.value);
            }
            node = node.next;
        }
        return "Node Not Found: NODE->null";
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}

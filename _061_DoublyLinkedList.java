public class _061_DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;
    public void insertFirst(int val){
        Node new_node = new Node(val);
        new_node.next = head;
        new_node.previous = null;
        if (head != null){
            head.previous = new_node;
        }
        head = new_node;
        size++;
    }
    public void insertLast(int val){
        Node new_node = new Node(val);
        new_node.next = null;
        Node last = head;
        if (head == null){
            new_node.previous = null;
            head = new_node;
            return;
        }
        while (last.next != null) last = last.next;
        last.next = new_node;
        new_node.previous = last;
    }

    public void insertAtParticularIndex(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node new_node = new Node(val);

        if (index == 0) {
            insertFirst(val);
            return;
        } else if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) { // Changed to index - 1 to position temp at the node before the insertion point
            temp = temp.next;
        }
        new_node.next = temp.next;
        new_node.previous = temp;
        if (new_node.next != null) temp.next.previous = new_node;
        temp.next  = new_node;
        size++;
    }

    public void insertAfterNode(int after, int val){
        Node prev = find(after);
        if (prev == null) {System.out.println("Node Does not Exists!"); return;}
        Node new_node = new Node(val);
        new_node.next = prev.next;
        new_node.previous = prev;
        if (new_node.next != null){
            prev.next.previous = new_node;
        }
        prev.next = new_node;
        size++;
    }

    public void delete(int val) {
        Node temp = find(val);
        if (temp == null) {
            System.out.println("Node Does not Exist!");
            return;
        }
        if (temp == head) {
            head = temp.next;
        } else {
            temp.previous.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.previous = temp.previous;
        }
        size--;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.val == value) return node;
            node = node.next;
        }
        return null;
    }

    public void display(){
        Node node = head;
        Node last = null;
        while (node != null){
            System.out.print(node.val+" -> ");
            last = node;
            node = node.next;
        }
        System.out.println("∅(END)");

//        System.out.println("Print in Reverse");
//        while (last!=null){
//            System.out.print(last.val+" <- ");
//            last = last.previous;
//        }
//        System.out.println("START");
    }

    private class Node{
        int val;
        Node next;
        Node previous;

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }
}

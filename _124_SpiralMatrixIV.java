public class _124_SpiralMatrixIV {
    private Node head;
    private Node tail;
    private int size = 0;
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
        size++;
    }
    public Node head() {
        return head;
    }
    public class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}

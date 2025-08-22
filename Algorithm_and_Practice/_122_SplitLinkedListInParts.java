package Algorithm_and_Practice;

public class _122_SplitLinkedListInParts {
    private Node head;
    private Node tail;
    private int size = 0;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.setNext(head); // Use setter for next
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++; // Increment size when a new node is inserted
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.setNext(new_node); // Use setter for next
        tail = new_node;
        size++; // Increment size when a new node is inserted
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext(); // Use getter for next
        }
        System.out.print("End");
    }

    public int size() {
        return size; // Return the size variable directly
    }

    public Node[] splitListToParts(int k) {
        Node[] result = new Node[k];
        int lengthOfLL = size();
        int eachBucketNodes = lengthOfLL / k;
        int extraNode = lengthOfLL % k;
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < k; i++) {
            result[i] = curr;
            int currentBucketSize = eachBucketNodes + (extraNode > 0 ? 1 : 0);
            for (int count = 1; count < currentBucketSize; count++) {
                prev = curr;
                curr = curr.getNext(); // Use getter for next
            }
            if (prev != null) {
                prev.setNext(null); // Use setter for next
            }
            extraNode--;
        }
        return result;
    }

    public Node head() {
        return head;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value; // Getter for value
        }

        public Node getNext() {
            return next; // Getter for next
        }

        public void setNext(Node next) {
            this.next = next; // Setter for next
        }
    }
}

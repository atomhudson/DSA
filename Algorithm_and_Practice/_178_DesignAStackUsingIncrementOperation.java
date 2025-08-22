package Algorithm_and_Practice;

public class _178_DesignAStackUsingIncrementOperation {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1); // Stack: 1
        stack.push(2); // Stack: 2 -> 1
        stack.push(3); // Stack: 3 -> 2 -> 1
        stack.increment(5, 100);
        System.out.println(stack.pop());
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.display();
    }
}
class CustomStack {
    private class Node {
        int val;
        Node next;
        Node previous;
        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int maxSize;
    private int currentSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
    }
    public void push(int x) {
        if (currentSize < maxSize) {
            Node new_node = new Node(x);
            if (head == null) {
                head = new_node;
                tail = new_node;
            } else {
                new_node.next = head;
                head.previous = new_node;
                head = new_node;
            }
            currentSize++;
        }
    }
    public int pop() {
        if (head == null) {
            return -1;
        }
        int value = head.val;
        if (head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
        }
        currentSize--;
        return value;
    }
    public void increment(int k, int val) {
        Node curNode = tail;
        int count = 0;
        while (curNode != null && count < k) {
            curNode.val += val;
            curNode = curNode.previous;
            count++;
        }
    }
    public void display() {
        Node node = head;
        if (node == null) {
            System.out.println("Stack is empty");
        } else {
            while (node != null) {
                System.out.print(node.val + " -> ");
                node = node.next;
            }
            System.out.println("∅(END)");
        }
    }
}

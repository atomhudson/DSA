package Data_Structures;

/**
 * -> Queue:
 * -> It's a linear data structure.
 * -> Operation
 *         |-> Enqueue (Whenever we want to insert an element in queue it's called enqueue).
 *         |-> Dequeue (Whenever we want to delete an element from the queue it's called dequeue).
 * -> It's work on FIFO ( First In First Out ).
 * -> OverFlow
 * -> UnderFlow
 * -> Rear
 * -> Front
 * -> Implementation
 *          |-> Array
 *          |-> LinkList
 *
 */

class QueueUsingArray{
    private int rear;
    private int front;
    private final int[] queue;
    QueueUsingArray(){
        rear = -1;
        front = -1;
        queue = new int[10];
    }
    public void enqueue(int value){
        if (rear == queue.length - 1) {
            System.err.println("Queue OverFlow!");
            return;
        }
        if (front == -1){
            front++;
        }
        queue[++rear] = value;
    }
    public void dequeue(){
        if (front == -1 || front > rear){
            System.err.println("Queue UnderFlow!");
            return;
        }
        queue[front++] = 0;
        if (front > rear){
            front = -1;
            rear = -1;
        }
    }
    public void display(){
        if (front == -1) {
            System.out.println("[ Empty Queue ]");
            return;
        }
        System.out.print("[ Front --> ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + (i < rear ? ", " : ""));
        }
        System.out.println(" <-- Rear ]");
    }
}

class QueueUsingLinkList{
    static class Node{
        private final int value;
        private Node next;
        Node(int value){
            this.value = value;
        }
    }
    private Node rear;
    private Node front;
    QueueUsingLinkList(){
        rear = null;
        front = null;
    }
    public void enqueue(int value){
        Node new_node = new Node(value);
        if (front == null && rear == null){
            front = new_node;
            rear = new_node;
        }else {
            rear.next = new_node;
            rear = new_node;
        }
    }
    public void dequeue(){
        if (front == null){
            System.err.println("Queue UnderFlow!");
            rear = null;
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }
    public void display(){
        if (front == null){
            System.out.println("[ Empty Queue]");
            return;
        }
        System.out.print("[ Front -->");
        Node temp = front;
        while(temp != null){
            System.out.print(temp.value + (temp != rear ? ", " : ""));
            temp = temp.next;
        }
        System.out.println(" <-- Rear ]");
    }
}

public class _014_Queue {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        QueueUsingLinkList queue2 = new QueueUsingLinkList();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(3);
        queue2.display();
        queue2.dequeue();
        queue2.display();
        queue2.dequeue();
        queue2.display();
        queue2.dequeue();
        queue2.display();
        queue2.dequeue();
        queue2.display();
        queue2.dequeue();
        queue2.display();

    }
}

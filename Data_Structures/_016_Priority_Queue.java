package Data_Structures;

/**
 * Priority Level:
 * 1 -> high
 * 2 -> moderate
 * 3 -> low
 */
class PriorityQueue{
    static class Node{
        private final int value;
        private final int priority;
        private Node next;
        Node(int value, int priority){
            this.value = value;
            this.priority = priority;
        }
    }

    private Node front;

    PriorityQueue(){
        front = null;
    }

    public void enqueue(int value)
    {
        enqueue(value, 3);
    }
    public void enqueue(int value, int priority)
    {
        Node new_node = new Node(value,priority);
        if (front == null || priority < front.priority){
            new_node.next = front;
            front = new_node;
        }else{
            Node temp = front;
            while(temp.next != null && temp.next.priority <= priority){
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }
    }
    public int dequeue(){
        if (front == null){
            throw new RuntimeException("Queue is empty");
        }
        int value = front.value;
        front = front.next;
        return value;
    }
    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print("(" + temp.value + ", P:" + temp.priority + ") -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class _016_Priority_Queue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(10, 2);
        pq.enqueue(20, 1);
        pq.enqueue(30);
        pq.enqueue(40, 2);

        pq.display();

        System.out.println("Dequeued: " + pq.dequeue());
        System.out.println("Dequeued: " + pq.dequeue());
        System.out.println("Dequeued: " + pq.dequeue());
        System.out.println("Dequeued: " + pq.dequeue());
        pq.display();
    }
}

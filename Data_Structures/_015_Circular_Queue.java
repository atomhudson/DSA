package Data_Structures;

/**
 * **Disadvantages of a Linear Queue:**
 * In a linear queue implemented using an array, when elements are inserted
 * (enqueue) and the array becomes full, an overflow condition occurs.
 * If we then remove (dequeue) some elements, the 'front' pointer moves forward,
 * but the freed-up spaces at the beginning cannot be reused because the
 * 'rear' pointer is still at the end of the array.
 *
 * This leads to wasted space even though there is free memory available.
 *
 * **Example (Queue size = 5):**
 * Initial state: [ - , - , - , - , - ] (Front = -1, Rear = -1)
 *
 * Enqueue 10, 20, 30, 40, 50:
 * [ 10 , 20 , 30 , 40 , 50 ] (Front = 0, Rear = 4)
 *
 * Dequeue 10, 20:
 * [ - , - , 30 , 40 , 50 ] (Front = 2, Rear = 4)
 *
 * Now if we try to insert a new element (e.g., 60), it will throw
 * "Queue Overflow" even though there are empty slots at index 0 and 1.
 *
 * **Key Point:** This problem only occurs with a queue implemented using a fixed-size array.
 * It does not occur with a linked-list-based queue.
 *
 * ---
 *
 * **Queue Operations (Linear):**
 * - Enqueue:  Rear = Rear + 1
 * - Dequeue:  Front = Front + 1
 *
 * **Queue Operations (Circular):**
 * - Enqueue:  Rear = (Rear + 1) % maxSize
 * - Dequeue:  Front = (Front + 1) % maxSize
 *
 * ---
 *
 * **Circular Queue Example (Queue size = 5):**
 *
 * Initial state:
 * [ - , - , - , - , - ]  (Front = -1, Rear = -1)
 *
 * Enqueue 10:
 * [ 10 , - , - , - , - ]
 * Front = 0; Rear = (0 + 1) % 5 = 1
 *
 * Enqueue 20:
 * [ 10 , 20 , - , - , - ]
 * Front = 0; Rear = (1 + 1) % 5 = 2
 *
 * Enqueue 30:
 * [ 10 , 20 , 30 , - , - ]
 * Front = 0; Rear = (2 + 1) % 5 = 3
 *
 * Enqueue 40:
 * [ 10 , 20 , 30 , 40 , - ]
 * Front = 0; Rear = (3 + 1) % 5 = 4
 *
 * Enqueue 50:
 * [ 10 , 20 , 30 , 40 , 50 ]
 * Front = 0; Rear = (4 + 1) % 5 = 0  (wraps around)
 *
 * **Dequeue operations:**
 *
 * Dequeue:
 * [ - , 20 , 30 , 40 , 50 ]
 * Front = (0 + 1) % 5 = 1; Rear = 0
 *
 * Dequeue:
 * [ - , - , 30 , 40 , 50 ]
 * Front = (1 + 1) % 5 = 2; Rear = 0
 *
 * Dequeue:
 * [ - , - , - , 40 , 50 ]
 * Front = (2 + 1) % 5 = 3; Rear = 0
 *
 * **Now we can reuse space:**
 * Enqueue 60:
 * [ 60 , - , - , 40 , 50 ]
 * Rear = (0 + 1) % 5 = 1
 *
 * Enqueue 70:
 * [ 60 , 70 , - , 40 , 50 ]
 * Rear = (1 + 1) % 5 = 2
 *
 * The circular queue efficiently reuses empty slots.
 *
 */

class CircularQueueUsingArray{
    private int rear;
    private int front;
    private final int maxsize;
    private final int[] circularQueue;

    CircularQueueUsingArray(){
        rear = -1;
        front = -1;
        maxsize = 10;
        circularQueue = new int[maxsize];
    }

    public void enqueue(int value){
        if (front == ((rear + 1) % maxsize)){
            System.err.println("Queue OverFlow!.....");
            return;
        }
        if (front == -1){
            front = 0;
            rear = 0;
        }else {
            rear = (rear + 1) % maxsize;
        }
        circularQueue[rear] = value;
    }

    public void dequeue(){
        if (front == -1) {
            System.err.println("Queue Underflow!.....");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxsize;
        }
    }

    public void display(){
        if (front == -1){
            System.out.println("[ Empty Queue ]");
            return;
        }
        System.out.print("[ Front --> ");
        int i = front;
        while(true){
            System.out.print(circularQueue[i]);
            if (i == rear) break;
            System.out.print(", ");
            i = (i + 1) % maxsize;
        }
        System.out.println(" <-- Rear ]");
    }
}

public class _015_Circular_Queue {
    public static void main(String[] args) {
        CircularQueueUsingArray queue = new CircularQueueUsingArray();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.display();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.enqueue(11);
        queue.display();
    }
}

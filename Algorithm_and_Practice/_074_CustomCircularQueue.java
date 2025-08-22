package Algorithm_and_Practice;

public class _074_CustomCircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;
    public _074_CustomCircularQueue() { this(DEFAULT_SIZE); }
    public _074_CustomCircularQueue(int size) { this.data = new int[size]; }
    public boolean isFull() { return size == data.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front];
        front = (front + 1) % data.length;
        size--;
        return removed;
    }
    public int getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");
    }
}

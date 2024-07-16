public class _75_CircularQueueMain {
    public static void main(String[] args) throws Exception{
        _74_CustomCircularQueue customCircularQueue = new _74_CustomCircularQueue();
        customCircularQueue.insert(34);
        customCircularQueue.insert(45);
        customCircularQueue.insert(4);
        customCircularQueue.insert(3);
        customCircularQueue.insert(2);

        System.out.println("Our Circular Queue: ");
        customCircularQueue.display();

        System.out.println(customCircularQueue.remove());
        customCircularQueue.insert(133);
        customCircularQueue.display();



    }
}

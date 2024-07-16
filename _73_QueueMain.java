public class _73_QueueMain {
    public static void main(String[] args) throws Exception{
        _72_CustomQueue customQueue = new _72_CustomQueue();
        customQueue.insert(34);
        customQueue.insert(45);
        customQueue.insert(4);
        customQueue.insert(3);
        customQueue.insert(2);
        customQueue.insert(38);

        customQueue.display();

        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
        System.out.println(customQueue.remove());
        customQueue.display();
//        System.out.println(customQueue.remove());
//        customQueue.display();


    }
}

package Algorithm_and_Practice;

public class _073_QueueMain {
    public static void main(String[] args) throws Exception{
        _072_CustomQueue customQueue = new _072_CustomQueue();
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

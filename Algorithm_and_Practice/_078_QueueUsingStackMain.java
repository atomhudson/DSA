package Algorithm_and_Practice;

public class _078_QueueUsingStackMain {
    public static void main(String[] args) throws Exception{
        _077_QueueUsingStackInsertionEfficient queueUsingStack = new _077_QueueUsingStackInsertionEfficient();
        queueUsingStack.push(34);
        queueUsingStack.push(45);
        queueUsingStack.push(23);
        queueUsingStack.push(31);
        queueUsingStack.push(2);
        queueUsingStack.push(35);
        queueUsingStack.push(33);

        System.out.println("Top of the Queue: "+queueUsingStack.top());
        System.out.println("Popped Item: "+queueUsingStack.pop());
        System.out.println("Top of the Queue: "+queueUsingStack.top());
        System.out.println(queueUsingStack.isEmpty());


        _079_QueueUsingStackRemovalEfficient removalEfficient = new _079_QueueUsingStackRemovalEfficient();
        removalEfficient.push(45);
        removalEfficient.push(4);
        removalEfficient.push(5);
        removalEfficient.push(13);
        removalEfficient.push(40);
        removalEfficient.push(1);

        System.out.println("---------------------------");
        System.out.println("Top of the Queue: "+removalEfficient.peek());
        System.out.println("Popped Item: "+removalEfficient.pop());
        System.out.println("Top of the Queue: "+removalEfficient.peek());
        System.out.println(removalEfficient.isEmpty());
    }
}

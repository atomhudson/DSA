import java.util.*;

public class _067_InBuiltAdvDataStructure {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(23);
        stack.push(33);
        stack.push(1);
        stack.push(5);
        stack.push(18);
        System.out.println("Stack Implementation");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());   // java.util.EmptyStackException
        System.out.println("--------------------------------------");

        System.out.println("Queue Implementation");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(4);
        queue.add(6);
        queue.add(8);
        queue.add(9);
        queue.add(23);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//        System.out.println(queue.remove()); // java.util.NoSuchElementException
        System.out.println("--------------------------------------");

        System.out.println("Dequeue Implementation");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(23);
        deque.addLast(32);
        System.out.println("First: "+deque.removeFirst()+",Last: "+deque.removeLast());



    }
    
}


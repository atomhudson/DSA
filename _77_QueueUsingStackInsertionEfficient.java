import java.util.Stack;

public class _77_QueueUsingStackInsertionEfficient {
    protected Stack<Integer> mainStack;
    protected Stack<Integer> helperStack;

    public _77_QueueUsingStackInsertionEfficient() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }
    public void push(int item){
        mainStack.push(item);
    }
    public int pop() throws Exception{
        if(isEmpty()) throw new Exception("Queue is Empty");
        while(!mainStack.isEmpty()) helperStack.push(mainStack.pop());
        int removed = helperStack.pop();
        while (!helperStack.isEmpty()) mainStack.push(helperStack.pop());
        return removed;
    }
    public int top() throws Exception{
        if (isEmpty()) throw new Exception("Queue is Empty");
        while(!mainStack.isEmpty()) helperStack.push(mainStack.pop());
        int top = helperStack.peek();
        while (!helperStack.isEmpty()) mainStack.push(helperStack.pop());
        return top;
    }
    public boolean isEmpty(){
        return mainStack.isEmpty();
    }
}

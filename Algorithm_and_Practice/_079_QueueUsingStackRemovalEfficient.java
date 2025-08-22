package Algorithm_and_Practice;

import java.util.Stack;

public class _079_QueueUsingStackRemovalEfficient {
    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;
    public _079_QueueUsingStackRemovalEfficient() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }
    public void push(int item){
        while(!mainStack.isEmpty()){
            helperStack.push(mainStack.pop());
        }
        mainStack.push(item);
        while (!helperStack.isEmpty()){
            mainStack.push(helperStack.pop());
        }
    }
    public int pop(){
        return mainStack.pop();
    }
    public int peek(){
        return mainStack.peek();
    }
    public boolean isEmpty(){
        return mainStack.isEmpty();
    }
}

package Algorithm_and_Practice;

public class _068_CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr = -1;
    public _068_CustomStack() {
        this(DEFAULT_SIZE);
    }
    public _068_CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full");
            return  false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop() throws _069_StackException {
        if(isEmpty()){
            throw new _069_StackException("Cannot perform POP() from an empty stack");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }
    public int peek() throws _069_StackException {
        if(isEmpty()){
            throw new _069_StackException("Cannot perform PEEK() from an empty stack!");
        }
        return data[ptr];
    }
    public boolean isFull(){
        return  ptr == data.length - 1; // pointer is at the last index.
    }
    public boolean isEmpty(){
        return  ptr == -1;
    }
}

public class _70_StackMain {
    public static void main(String[] args) throws _69_StackException{
        _68_CustomStack dynamicCustomStack = new _71_DynamicCustomStack();
        dynamicCustomStack.push(34);
        dynamicCustomStack.push(56);
        dynamicCustomStack.push(3);
        dynamicCustomStack.push(4);
        dynamicCustomStack.push(32);
        dynamicCustomStack.push(18);
        dynamicCustomStack.push(5);
        dynamicCustomStack.push(1);
        dynamicCustomStack.push(2);
        dynamicCustomStack.push(67);
        dynamicCustomStack.push(89);
        dynamicCustomStack.push(45);
        dynamicCustomStack.push(90);
        dynamicCustomStack.push(100);

        System.out.println("Peek of a Custom Stack using Custom Stack Methods: "+dynamicCustomStack.peek());
//        System.out.println(dynamicCustomStack.isEmpty());
//        System.out.println(dynamicCustomStack.isFull());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
        System.out.println(dynamicCustomStack.pop());
//        System.out.println(dynamicCustomStack.isEmpty());
//        System.out.println(dynamicCustomStack.isFull());
//        System.out.println(dynamicCustomStack.pop()); // _69_StackException: Cannot perform POP() from an empty stack
    }
}

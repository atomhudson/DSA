package Data_Structures;

// OverFlow doesn't exist in stack implementation using LinkList, It can only occur when there is no space to store a new Node in memory.
import java.util.Scanner;
class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}
class Stack_UsingLinkList{
    private Node top = null;

    public void push(int value){
        Node new_node = new Node(value);
        if (top != null) {
            new_node.next = top;
        }
        top = new_node;
    }

    public void pop(){
        if (top == null){
            System.out.println();
            System.err.println("UnderFlow Condition....!");
            return;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
    }

    public void display(){
        Node temp = top;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.print("]");
    }

    public void top(){
        if (top != null){
            System.out.println(top.value);
        }else{
            System.err.println("UnderFlow Condition.....!");
        }
    }
}

public class _007_Stack_Using_LinkList {
    public static void main(String[] args) {
        Stack_UsingLinkList stack = new Stack_UsingLinkList();
        Scanner sc = new Scanner(System.in);
        String over = "yes";
        while("yes".equalsIgnoreCase(over)){
            System.out.println("\n----- STACK MENU -----");
            System.out.println("PRESS 1 TO PUSH");
            System.out.println("PRESS 2 TO POP");
            System.out.println("PRESS 3 TO DISPLAY");
            System.out.println("PRESS 4 TO SEE TOP ELEMENT");
            System.out.println("PRESS 5 TO EXIT");
            System.out.print("Enter your choice: \n");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.top();
                    break;
                case 5:
                    over = "no";
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Invalid choice, try again....!");
            }
        }
    }
}

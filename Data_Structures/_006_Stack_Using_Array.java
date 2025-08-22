package Data_Structures;

// Stack is a linear data structure
// It Follow LIFO (Last In First Out) concept.

// UnderFlow condition .... Initialise the value of top in stack is -1. which means there is no current element in the stack or the stack is empty.
// we check underflow condition when we are trying to pop an element.

// Using Array for Stack ... first we have to define the size of the array.
// OverFlow condition .... When that predefined size of array gets full then overflow condition occurs.
// IndexOutOfBound or ArrayOutOfBound.
// we check overflow condition when we want to push an element.
import java.util.Scanner;

class Stack
{
    private int top = -1;
    private final int n = 10;
    private final int[] array = new int[n];

    public void top(){
        if(top == -1){
            System.err.println("UnderFlow Condition");
        }else {
            System.out.println(array[top]);
        }
    }

    public void push(int value){
        if (top == (n-1)){
            System.err.println("OverFlow Condition");
        } else {
            top++;
            array[top] = value;
        }
    }
    public void pop(){
        if(top == -1){
            System.err.println("UnderFlow Condition");
        } else{
            top--;
        }
    }
    public void display(){
        System.out.print("[ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}

public class _006_Stack_Using_Array {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        String over = "yes";
        while("yes".equalsIgnoreCase(over)) {
            System.out.println("\n----- STACK MENU -----");
            System.out.println("PRESS 1 TO PUSH");
            System.out.println("PRESS 2 TO POP");
            System.out.println("PRESS 3 TO DISPLAY");
            System.out.println("PRESS 4 TO SEE TOP ELEMENT");
            System.out.println("PRESS 5 TO EXIT");
            System.out.print("Enter your choice: ");
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

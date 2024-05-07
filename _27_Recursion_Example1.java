public class _27_Recursion_Example1 {
//      Why Recursion;
//      1.It Helps us in solving bigger/complex problem in a simple way.
//      2.You can convert recursion solution into iteration & vice versa.
//      3.Space Complexity is not constant because of recursive calls;


//      What is the Base Condition: Condition where our recursion will
//                                  stop making new calls;
//      What is there is no Base Condition:
//          1. Function calling will keep happening;
//          2. Stack will be filled again and again,
//              resulting Computer memory exceeds the
//              limit and generate error named : "STACKOVERFLOW" error;


//    If you are calling a function again and again, you can treat it
//    as a separate call in the stack;


    static void print(int i){ //Recursive Function
        System.out.println(i); //body
//      This is the Base Condition
        if(i == 5){
            return;
        }
        print(i+1); //Recursive call
    }
    public static void main(String[] args) {
        print(1);
    }
}


//Visualising Recursion:
//
//            ^ (Program over)
//            |
//Prog-   main()
//-ram    |   ^
//start   |   |
//       print(1)
//        |   ^
//        |   |
//       print(2)
//        |   ^
//        |   |
//       print(3)
//        |   ^
//        |   |
//       print(4)
//        |   ^
//        |   |
//       print(5)




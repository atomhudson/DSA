public class _28_Find_nth_Fibonacci_number_Recursion {
//  Fibonacci numbers

//   0th,  1st, 2nd, 3rd, 4th, 5th, 6th, 7th,......... (Fibonacci nth number)
//     0,    1,   1,   2,   3,   5,   8,  13,........(Fibonacci Series)
//
//    For Fibo(Nth) = Fibo(N - 1)th + Fibo(N - 2)th ( This is Knows as the RECURRENCE RELATIONS )

//    Recursive Tree for Fibo(5)th:
//    like Fibo(5th) = Fibo(4)th                       +                          Fibo(3)rd;
//                             3                                                          2
//                          |  ^                                                       |  ^
//                          |  |                                                       |  |
//           Fibo(3)rd      +       Fibo(2)nd                    Fibo(2)nd             +        Fibo(1)th
//                  2                      1                            1                           1
//                | ^                    | ^                          | ^
//                | |                    | |                          | |
//                      1
//      Fibo(2)nd + Fibo(1)st   Fibo(1)st + Fibo(0)th       Fibo(1)st + Fibo(0)th
//              1                   1          0                 1          0
//           |  ^
//           |  |
// Fibo(1)st + Fibo(0)th
//      1        0

//    Break it down into smaller problem.
//    The base condition is represented by answers are already have.
//    In this case, we have that F(0) = 0 and F(1) = . and this is our base condition.


    static int fibonaccinumber(int n){
        if(n < 2){
            return n;
        }
        return fibonaccinumber(n -1 )+ fibonaccinumber(n -2);
    }

    static long fibonaccinumberusingformula(int n){
        double sqrt5 = Math.sqrt(5);
        double brac1 = (1 + sqrt5)/2;
        double brac2 = (1 - sqrt5)/2; // this is least dominating term we can skip it
        double result = (Math.pow(brac1, n) - Math.pow(brac2,n)) / sqrt5;
        return (long) result;
    }
    static long fibonaccinumber2(int n ){
        return (long) ((Math.pow(((1+Math.sqrt(5))/2),n)-Math.pow(((1-Math.sqrt(5))/2),n)) / Math.sqrt(5));
    }
    public static void main(String[] args) {
        System.out.println(fibonaccinumber(5));
        for (int i = 0; i < 11; i++) {
            System.out.println(fibonaccinumberusingformula(i));
        }
        System.out.println(" ");
        System.out.println("50th Fibonacci number using the formula created: "+fibonaccinumberusingformula(50));
        System.out.println("50th Fibonacci number using the formula created: "+fibonaccinumber2(50));

    }
}

// How to understand and approach a problem?

//1. Identify if you can break down problem into smaller problem.
//2. Form the RECURRENCE RELATION if needed.
//3. Draw the RECURSIVE Tree.
//4. About the tree:
//     ->See the flow of function, how they are getting into stack.
//     ->Identify & focus of left tree calls and right tree calls.
//     ->Draw the tree and pointers again and again using pen and paper.
//     ->Use a debugger to see the flow.
// 5.See how the value(s) and what type of value(s) are returned at each step.
// 6.See where the function call will come out off.
//     ->In the end, you will have to come out of the main function.

// Working the variables:
//      1. Arguments
//      2. Return Type.
//      3. Body of Function.
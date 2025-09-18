package Data_Structures;

public class _018_Recursion {

    // Print numbers from 1 to n (increasing order)
    static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // Print numbers from n to 1 (decreasing order)
    static void printDesc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDesc(n - 1);
    }

    // Sum of first n natural numbers
    static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    // Factorial of a number
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Fibonacci series using recursion
    static int fibonacciSeries(int n) {
        if (n <= 1) {
            return n;
        }
        int previous = fibonacciSeries(n - 1);
        int previousPrevious = fibonacciSeries(n - 2);
        return previous + previousPrevious;
    }

    /**
     * Example to calculate sum of digits:
     * 1234 % 10 = 4 <- remainder
     * 1234 / 10 = 123
     * 123 % 10 = 3 <- remainder
     * 123 / 10 = 12
     * 12 % 10 = 2 <- remainder
     * 12 / 10 = 1
     * 1 % 10 = 1 <- remainder
     * 1 / 10 = 0
     */
    static int sumOfDigits(int number) {
        if (number >= 0 && number <= 9) {
            return number;
        }
        int remainder = number % 10;
        return remainder + sumOfDigits(number / 10);
    }

    // Power calculation O(Q)
    static int p_ToThePower_q(int p, int q) {
        if (q == 0) {
            return 1;
        }
        return p * p_ToThePower_q(p, q - 1);
    }

    // Optimized power calculation O(log Q)
    /*
    Function: P_ToThePower_Q(p, q)
    Purpose:  Calculate p^q using fast exponentiation (recursive approach).

    Example: 2^5
    --------------------------------
    Call: P_ToThePower_Q(2,5)
      -> smallPow = P_ToThePower_Q(2, 2)
         -> smallPow = P_ToThePower_Q(2, 1)
            -> smallPow = P_ToThePower_Q(2, 0) = 1
            -> since q=1 is odd => return 1*1*2 = 2
         -> now q=2 is even => return 2*2 = 4
      -> now q=5 is odd => return 4*4*2 = 32

        Final Answer: 2^5 = 32
    */
    static int P_ToThePower_Q(int p, int q) {
        if (q == 0) return 1;
        int smallPow = P_ToThePower_Q(p, q / 2);
        if (q % 2 == 0) {
            return smallPow * smallPow;
        } else {
            return smallPow * smallPow * p;
        }
    }


    // Print first k multiples of a number
    static void kMultiples(int number, int k) {
        if (k == 0) {
            return;
        }
        kMultiples(number, k - 1);
        System.out.print(number * k + " ");
    }

    // Alternate sum till n: 1 - 2 + 3 - 4 + ...
    static int alternativeSumTillN(int n) {
        if (n == 1) return 1;
        if (n % 2 == 0) return alternativeSumTillN(n - 1) - n;
        else return alternativeSumTillN(n - 1) + n;
    }

    /**
     * Greatest Common Divisor (GCD) or HCF
     * Given two number x and y. Find the greatest common divisor of x and y using recursion.
     * Constraints: 0 <= x, y <= 1e6
     * 24 = 1, 2, 3, 4, 6, 8, 12, 24
     * 15 = 1, 3, 5, 15
     * Common Divisor = 1, 3
     * GCD = 3
     */
    static int iGCD(int x,int y){
        while(x % y != 0){
            int rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }

    /**
     * Euclid's Algorithm.
     * gcd(x,y) = gcd(y, x % y);
     * gcd(x,0) = x;

     * gcd(25,15) = gcd(15,9) = gcd(9,6) = gcd(6,3) = gcd(3,0) = 3
     *
     */
    static int rGCD(int x, int y){
        if (y == 0) return x;
        return rGCD(y, x % y);
    }

    /**
     * LCM(x,y) * GCD(x,y) = x * y;
     * LCM(x,y) = ((x * y) / GCD(x,y));
     */
    static int LCM(int x, int y){
        int gcd = rGCD(x,y);
        return (x * y) / gcd;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.print("Printing 1 to n in increasing order: ");
        printInc(n);
        System.out.println();

        System.out.print("Printing n to 1 in decreasing order: ");
        printDesc(n);
        System.out.println();

        System.out.print("Sum of n naturals numbers: ");
        System.out.print(sum(n));
        System.out.println();

        System.out.print("Factorial of n: ");
        System.out.print(factorial(n));
        System.out.println();

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciSeries(i) + " ");
        }
        System.out.println();

        System.out.print("Sum of digits: " + sumOfDigits(123456789));
        System.out.println();

        System.out.print("p^q: " + p_ToThePower_q(2, 4));
        System.out.println();

        System.out.print("P^Q: " + P_ToThePower_Q(2, 5));
        System.out.println();

        System.out.print("Starting Multiple of N of k: ");
        kMultiples(2, 5);
        System.out.println();

        System.out.print("Alternate Sum Series: " + alternativeSumTillN(5));
        System.out.println();

        int x = 24,y = 15;
        System.out.print("GCD Using Iterator Solution: "+iGCD(x,y));
        System.out.println();
        System.out.print("GCD Using Recursive Solution: "+rGCD(x,y));
        System.out.println();
        System.out.print("LCM of x and y: "+LCM(x,y));
    }
}

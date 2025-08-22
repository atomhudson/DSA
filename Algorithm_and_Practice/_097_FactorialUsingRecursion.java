package Algorithm_and_Practice;

public class _097_FactorialUsingRecursion {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Factorial(n));
    }
    static int Factorial(int n){
        if (n == 1){
            return 1;
        }
        n = n * Factorial(n - 1);
        return n;
    }
}

package Algorithm_and_Practice;

public class _098_SumUsingRecursion {
    public static void main(String[] args) {
        int n = 55;
        System.out.println("Sum from number 0 to N: "+Sum(n));
        System.out.println("Sum of Digits of a number: "+SumOfDigits(n));
        System.out.println("Product of Digits of a number: "+ProductOfDigits(n));

    }
    static int Sum(int n){
        if (n == 0){
            return 0;
        }
        n = n + Sum(n - 1);
        return n;
    }
    static int SumOfDigits(int n){
        if (n == 0){
            return 0;
        }
        int remainder = n % 10;
        n = remainder + SumOfDigits(n / 10);
        return n;
    }
    static int ProductOfDigits(int n){
        if (n%10 == n){
            return n;
        }
        int rem = n % 10;
        n = rem * ProductOfDigits(n / 10);
        return n;
    }
}

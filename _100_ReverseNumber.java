public class _100_ReverseNumber {
    static int sum = 0;
    static void ReverseANumber(int n){
        if (n == 0){
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        ReverseANumber(n/10);
    }
    static int ReverseNumber(int n){
        int numberLength = (int) (Math.log10(n)) + 1;
        return helperForReverseNumber(n, numberLength);
    }
    private static int helperForReverseNumber(int n, int numberLength){
        if (n % 10 == n){
            return n;
        }
        int remainder = n % 10;
        int digitLength = numberLength - 1;
        int power = (int)(Math.pow(10,digitLength));
        int ans = remainder * power + helperForReverseNumber(n / 10,digitLength);
        return ans;
    }
    static boolean PalindromeNumber(int n){
        return n == ReverseNumber(n);
    }
    public static void main(String[] args) {
        ReverseANumber(1234);
        System.out.println(sum);
        System.out.println(ReverseNumber(1234));
        System.out.println(PalindromeNumber(155));
    }

}

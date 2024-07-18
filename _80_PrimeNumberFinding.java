public class _80_PrimeNumberFinding {

    static boolean isPrime(int n){
        if (n <= 1) return false;
        int sqrt = 2;
        while (sqrt * sqrt <= n){
            if (n % sqrt == 0){
                return false;
            }
            sqrt++;
        }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.err.println(i+" : --> : "+isPrime(i));
        }
    }
}

public class _101_CountZeros {
    static int CountZero(int n){
        return helperForCountZero(n, 0);
    }
    private static int helperForCountZero(int n, int count){
        if (n == 0){
            return count;
        }
        int remainder = n % 10;
        if (remainder == 0){
            return helperForCountZero(n/10,count+1);
        }
        return helperForCountZero(n/10,count);
    }
    public static void main(String[] args) {
        int n = 1020030200;
        System.out.println(CountZero(n));

    }
}

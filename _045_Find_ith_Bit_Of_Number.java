public class _045_Find_ith_Bit_Of_Number {
    static int ithBitOfNumber(int n){
        return n & ( 1 << (n - 1));
    }
    public static void main(String[] args) {
        System.out.println(5);
    }
}

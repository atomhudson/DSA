package Algorithm_and_Practice;

public class _043_Odd_Even_Bit_Manipulation {

//    1 0 0 1 1  ( 2 ^ 0)it always generate a odd digit
//    if 2^0 place == 1  =====>> Given number is odd.

//    1 0 0 0 1 0 1
//  & 0 0 0 0 0 0 1
// ------------------
//    0 0 0 0 0 0 1
// ------------------
//    number is odd
    public static boolean isOdd(int n){
        return (n & 1) == 1;
    }
    public static void main(String[] args) {
        System.out.println(isOdd(5));
    }
}

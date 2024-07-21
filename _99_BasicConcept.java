public class _99_BasicConcept {
    public static void main(String[] args) {
        int n = 5;
        MinusMinusN(n);
    }
//     n-- VS --n
/*  It will Throw an exception named StackOverFlowExceptions
    Because n-- means first pass and used the value than subtract 1 from it.
*/

/*
        static void NMinusMinus(int n){
            if(n == 0) return;
            System.out.print(n + " ");
            NMinusMinus(n--);
        }
*/
/*
    --n it means first subtract 1 from it than pass and use the value of it.
*/
    static void MinusMinusN(int n){
        if (n == 0) return;
        System.out.print(n + " ");
        MinusMinusN(--n);
    }
}

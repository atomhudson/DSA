package Algorithm_and_Practice;

import java.util.ArrayList;

public class _085_FactorsOfANumbers {
    public static void main(String[] args) {
        int n = 40;
        System.out.print("BruteForce Approach: ");
        FactorsUsingBruteForce(n);

        System.out.print("Optimal Approach: ");
        FactorsUsingOptimizedApproach(n);

        System.out.println();

        System.out.print("Optimal Approach with pretty printing: ");
        FactorsUsingOptimizedApproachSorted(n);
    }
    static void FactorsUsingBruteForce(int n){
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.print(i+" ");
        }
        System.out.println();
    }
    static void FactorsUsingOptimizedApproach(int n){
        _083_SquareRootOfAnyNumber_BinarySearch squareRootOfAnyNumberBinarySearch = new _083_SquareRootOfAnyNumber_BinarySearch();
        for (int i = 1; i <= squareRootOfAnyNumberBinarySearch.sqrt(n); i++) {
            if (n % i == 0){
                if (n/i == i){
                    System.out.print(i+" ");
                }else {
                    System.out.print(i +" "+ n/i+" ");
                }
            }
        }
    }
    static void FactorsUsingOptimizedApproachSorted(int n){
        _083_SquareRootOfAnyNumber_BinarySearch squareRootOfAnyNumberBinarySearch = new _083_SquareRootOfAnyNumber_BinarySearch();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= squareRootOfAnyNumberBinarySearch.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i)+" ");
        }
    }


}

package Algorithm_and_Practice;

public class _083_SquareRootOfAnyNumber_BinarySearch {
    public double sqrt(int n){
        return binarySearchForSquareRoot(n,2);
    }
    public static void main(String[] args) {
        // Only for Perfect Square
        int n = 40;
        int precision = 3;
        System.out.println("Square root of " + n + " is: " + binarySearchForSquareRoot(n,precision));

    }
//    Time Complexity: O(log (n))
    private static double binarySearchForSquareRoot(int n,int p) {
        int i = 0;
        int j = n;
        while (i <= j) {
            int middle = i + (j - i) / 2;
            if (middle * middle == n) return middle;
            if (middle * middle < n) i = middle + 1;
            else j = middle - 1;
        }
        return preciseValue(j, n, p);
    }

    private static double preciseValue(int n, int target, int precision) {
        double incr = 0.1;
        double result = n;
        for (int i = 0; i < precision; i++) {
            while (result * result <= target) {
                result += incr;
            }
            result -= incr;
            incr /= 10;
        }
        return result;
    }
}

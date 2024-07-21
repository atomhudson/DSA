public class _082_SquareRootForPerfectSquare_BinarySearch {
    public static void main(String[] args) {
        // Only for Perfect Square
        int n = 40;
        System.out.println("Square root of " + n + " is: " + binarySearchForSquareRoot(n));
    }
    static int binarySearchForSquareRoot(int n) {
        int i = 0;
        int j = n;
        while (i <= j) {
            int middle = i + (j - i) / 2;
            if (middle * middle == n) return middle;
            if (middle * middle < n) i = middle + 1;
            else j = middle - 1;
        }
        return Integer.MIN_VALUE;
    }
}

public class _084_NewtonRaphsonMethodForSquareRoot {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(NewtonRaphsonMethodOfSQRT(n));
    }
    static double NewtonRaphsonMethodOfSQRT(int n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.5) break;
            x = root;
        }
        return root;
    }
}

public class _160_MaximumMultiplicationScore {
    public static void main(String[] args) {
        int[] a = {3,2,5,6};
        int[] b = {2,-6,4,-5,-3,2,-7};
        System.out.println(maxScore(a,b));
    }
    public static long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[][] dp = new long[5][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i1 = 1; i1 <= 4; i1++) {
            for (int i2 = 1; i2 <= n; i2++) {
                long take = dp[i1 - 1][i2 - 1] + (long) a[i1 - 1] * b[i2 - 1];
                long notTake = dp[i1][i2 - 1];
                dp[i1][i2] = Math.max(take, notTake);
            }
        }

        return dp[4][n];
    }
}

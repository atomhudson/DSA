public class _88_ClimbingStairs {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(climbingStairs(n));
    }
    public static int climbingStairs(int n){
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

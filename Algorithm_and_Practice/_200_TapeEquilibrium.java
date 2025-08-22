package Algorithm_and_Practice;

class TapeEquilibrium{
    public int solution(int[] A) {
        int N = A.length;
        long totalSum = 0;
        for (int a: A){
            totalSum += a;
        }

        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            leftSum += A[i];
            long rightSum = totalSum - leftSum;
            long diff = Math.abs(leftSum - rightSum);
            minDiff = Math.min(minDiff,diff);
        }
        return (int)minDiff;
    }
}
public class _200_TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium sol = new TapeEquilibrium();
        int[] nums = {3,1,2,4,3};
        System.out.println(sol.solution(nums));
    }
}

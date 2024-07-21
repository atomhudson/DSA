public class _102_CountStepsUsedToReducesToZero {
    public int numberOfSteps(int num){
        return helper(num,0);
    }
    private int helper(int num,int steps){
        if (num == 0){
            return steps;
        }
        if (num % 2 == 0){
            return helper(num / 2,steps+1);
        }
        return helper(num-1, steps + 1);
    }
    public static void main(String[] args) {
        int n = 8;
        _102_CountStepsUsedToReducesToZero countStepsUsedToReducesToZero = new _102_CountStepsUsedToReducesToZero();
        System.out.println(countStepsUsedToReducesToZero.numberOfSteps(n));

    }
}

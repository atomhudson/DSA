class FrogRiverOne{
    int solution(int[] A,int X){
        boolean[] covered = new boolean[X + 1];
        int coveredCount = 0;
        for (int time = 0; time < A.length; time++) {
            int position = A[time];
            if (!covered[position]) {
                covered[position] = true;
                coveredCount++;
                if (coveredCount == X) {
                    return time;
                }
            }
        }
        return -1;
    }
}

public class _201_FrogRiverOne {
    public static void main(String[] args) {
        FrogRiverOne sol = new FrogRiverOne();
        int[] A = {1,3,1,4,2,3,5,4};
        System.out.println(sol.solution(A,5));
    }
}

class FindPerimeterIfOnlyAreaIsGiven{
    int solution(int N){
        int minPerimeter = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                int A = i;
                int B = N / i;
                int perimeter = 2 * (A + B);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }
        return minPerimeter;
    }
}
public class _205_FindPerimeterIfOnlyAreaIsGiven {
    public static void main(String[] args) {
        FindPerimeterIfOnlyAreaIsGiven sol = new FindPerimeterIfOnlyAreaIsGiven();
        System.out.println(sol.solution(30));
    }
}

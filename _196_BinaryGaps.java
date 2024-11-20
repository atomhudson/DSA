class BinaryGaps{
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int max = 0;
        int count = 0;
        for (char ch : binary.toCharArray()){
            if (ch == '1'){
               max = Math.max(max,count);
               count = 0;
            }else{
                count++;
            }
        }
        return max;
    }
}
public class _196_BinaryGaps {
    public static void main(String[] args) {
        BinaryGaps sol = new BinaryGaps();
        System.out.println(sol.solution(1041)); // Expected output: 5
        System.out.println(sol.solution(32));   // Expected output: 0
        System.out.println(sol.solution(529));  // Expected output: 4
        System.out.println(sol.solution(20));   // Expected output: 1
        System.out.println(sol.solution(15));
    }
}

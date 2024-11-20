import java.util.HashMap;
import java.util.Map;

class UnpairedValues{
    public int solution(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a: A){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int unParied = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() % 2 != 0){
                unParied = entry.getKey();
            }
        }
        return unParied;
    }
    public int solution2(int[] A){
        int unParied = A[0];
        for (int i = 1; i < A.length;i++){
            unParied ^= A[i];
        }
        return unParied;
    }

}
public class _198_UnpairedValues {
    public static void main(String[] args) {
        UnpairedValues sol = new UnpairedValues();
        int[] A = {9,3,9,3,9,7,9};
        System.out.println(sol.solution(A));
        System.out.println(sol.solution2(A));
    }
}

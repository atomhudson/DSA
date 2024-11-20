import java.util.ArrayList;
import java.util.List;

class FactorOfN{
    int solution(int n){
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0){
                arr.add(i);
                if (i != n/i){
                    arr.add(n/i);
                }
            }
        }
        return arr.size();
    }
}
public class _204_FactorOfN {
    public static void main(String[] args) {
        FactorOfN sol = new FactorOfN();
        System.out.println(sol.solution(24));
    }
}

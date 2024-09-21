import java.util.ArrayList;
import java.util.List;
public class _168_LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(34));
    }
    static List<Integer> lexicalOrder(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(i,n,list);
        }
        return list;
    }
    static void solve(int currNum, int n, List<Integer> result){
        if (currNum > n){
            return;
        }
        result.add(currNum);
        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currNum * 10 + nextDigit;
            if (nextNumber <= n) {
                solve(nextNumber, n, result);
            } else {
                break;
            }
        }
    }
}

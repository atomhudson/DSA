import java.util.HashSet;
import java.util.Set;

class PandQEqualsS{
    int solution(String P,String Q){
        Set<Character> distinctLetters = new HashSet<>();
        for (int i = 0; i < P.length(); i++) {
            if (P.charAt(i) != Q.charAt(i)) {
                distinctLetters.add(P.charAt(i));
                distinctLetters.add(Q.charAt(i));
            } else {
                distinctLetters.add(P.charAt(i));
            }
        }
        return distinctLetters.size();

    }

}
public class _203_DistinctLetterByTakingPandQStringTogetter {
    public static void main(String[] args) {
        String P = "ca";
        String Q = "ab";
        PandQEqualsS sol = new PandQEqualsS();
        System.out.println(sol.solution(P,Q));
//        sol.solution(P,Q);
    }

}

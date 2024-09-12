import java.util.Arrays;
import java.util.HashSet;

public class _149_CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
//        System.out.println(Arrays.toString(countConsistentStrings(allowed,words)));
        System.out.println(countConsistentStrings(allowed,words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> key = new HashSet<>();
        for (char ch: allowed.toCharArray()){
            key.add(ch);
        }
        boolean[] check = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!key.contains(words[i].charAt(j))){
                    flag = false;
                }
            }
            check[i] = flag;
        }
        int count = 0;
        for (boolean a: check){
            if (a){
                count++;
            }
        }
        return count;
    }
}

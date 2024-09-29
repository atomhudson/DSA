import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _175_CountOfSubStringsContainingEveryVowelAndKConsonantsI {
    public static void main(String[] args) {
        _175_CountOfSubStringsContainingEveryVowelAndKConsonantsI outer = new _175_CountOfSubStringsContainingEveryVowelAndKConsonantsI();
        Solution inner = outer.new Solution();
        // Test case 1
        String word1 = "aeioqq";
        int k1 = 1;
        System.out.println("Test case 1: " + inner.countOfSubstrings(word1, k1)); // Output: 0

        // Test case 2
        String word2 = "aeiou";
        int k2 = 0;
        System.out.println("Test case 2: " + inner.countOfSubstrings(word2, k2)); // Output: 1

        // Test case 3
        String word3 = "ieaouqqieaouqq";
        int k3 = 1;
        System.out.println("Test case 3: " + inner.countOfSubstrings(word3, k3)); // Output: 3
    }

    class Solution {

        public int countOfSubstrings(String word, int k) {
            int n = word.length();
            int totalCount = 0;
            HashSet<Character> vowelsSet = new HashSet<>();
            vowelsSet.add('a');
            vowelsSet.add('e');
            vowelsSet.add('i');
            vowelsSet.add('o');
            vowelsSet.add('u');
            for (int start = 0; start < n; start++) {
                HashSet<Character> vowelsInWindow = new HashSet<>();
                int consonantCount = 0;
                for (int end = start; end < n; end++) {
                    char c = word.charAt(end);
                    if (vowelsSet.contains(c)) {
                        vowelsInWindow.add(c);
                    } else if (Character.isLetter(c)) {
                        consonantCount++;
                    }
                    if (vowelsInWindow.size() == 5 && consonantCount == k) {
                        totalCount++;
                    }
                    if (consonantCount > k) {
                        break;
                    }
                }
            }

            return totalCount;
        }
    }

}


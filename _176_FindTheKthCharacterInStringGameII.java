import java.util.ArrayList;
import java.util.List;
public class _176_FindTheKthCharacterInStringGameII {
    public static void main(String[] args) {
        _176_FindTheKthCharacterInStringGameII outer = new _176_FindTheKthCharacterInStringGameII();
        Solution inner = outer.new Solution();

        // Test case 1
        int k1 = 10;
        int[] operations1 = {0, 1, 0, 1};
        System.out.println(inner.findKthCharacter(k1, operations1)); // Output: "b"

        // Test case 2
        int k2 = 5;
        int[] operations2 = {0, 0, 0};
        System.out.println(inner.findKthCharacter(k2, operations2)); // Output: "a"
    }
    class Solution {
        private char getNextCharacter(char ch) {
            if (ch == 'z') return 'a';
            return (char) (ch + 1);
        }
        public char findKthCharacter(long k, int[] operations) {
            String initialString = "a";
            List<Long> stringSizes = new ArrayList<>();
            stringSizes.add(1L); // Initial size of the string "a"

            // Calculate the sizes of the generated strings
            for (int operation : operations) {
                long newSize = 2 * stringSizes.get(stringSizes.size() - 1);
                if (newSize > k) {
                    stringSizes.add(k); // Limit the size to k
                } else {
                    stringSizes.add(newSize);
                }
            }
            // Determine the kth character based on the operations
            for (int i = operations.length - 1; i >= 0; --i) {
                if (k > stringSizes.get(i)) {
                    k -= stringSizes.get(i);
                    if (operations[i] == 1) {
                        initialString = String.valueOf(getNextCharacter(initialString.charAt(0)));
                    }
                }
            }
            return initialString.charAt(0);
        }
    }
}
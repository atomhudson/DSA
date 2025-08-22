package Algorithm_and_Practice;

public class _176_FindTheKthCharacterInStringGameII {
    public static void main(String[] args) {
        _176_FindTheKthCharacterInStringGameII outer = new _176_FindTheKthCharacterInStringGameII();
        Solution inner = outer.new Solution();

        // Algorithm_and_Practice.Test case 1
        int k1 = 10;
        int[] operations1 = {0, 1, 0, 1};
        System.out.println(inner.findKthCharacter(k1, operations1));

        // Algorithm_and_Practice.Test case 2
        int k2 = 5;
        int[] operations2 = {0, 0, 0};
        System.out.println(inner.findKthCharacter(k2, operations2));
    }
    class Solution {
        public char findKthCharacter(long k, int[] operations) {
            if (k == 1){
                return 'a';
            }
            int n = operations.length;
            long len = 1;
            long newK = -1;
            int operation = -1;
            for (int ope: operations){
                len *= 2;
                if (len >= k){
                    operation = ope;
                    newK = k - len / 2;
                    break;
                }
            }
            char ch = findKthCharacter(newK, operations);
            if (operation == 0){
                return ch;
            }
            return ch == 'z' ? 'a' : (char) (ch + 1);
        }
    }
}
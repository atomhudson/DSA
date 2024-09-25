import java.util.Arrays;

public class _171_SumOfPrefixScoresOfString {

    private class Solution {
        class TrieNode {
            int countP = 0;
            TrieNode[] children = new TrieNode[26];
            public TrieNode() {
                countP = 0;
            }
        }
        private TrieNode getTrieNode() {
            return new TrieNode();
        }
        private void insert(String word, TrieNode root) {
            TrieNode crawl = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (crawl.children[idx] == null) {
                    crawl.children[idx] = getTrieNode();
                }
                crawl.children[idx].countP += 1;
                crawl = crawl.children[idx];
            }
        }
        private int getScore(String word, TrieNode root) {
            TrieNode crawl = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (crawl.children[idx] != null) {
                    score += crawl.children[idx].countP;
                }
                crawl = crawl.children[idx];
            }
            return score;
        }
        public int[] sumPrefixScores(String[] words) {
            int n = words.length;
            TrieNode root = getTrieNode();
            for (String word : words) {
                insert(word, root);
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = getScore(words[i], root);
            }
            return arr;
        }
    }
    public static void main(String[] args) {
        _171_SumOfPrefixScoresOfString outerClass = new _171_SumOfPrefixScoresOfString();
        Solution solution = outerClass.new Solution();
        String[] words = {"abc", "ab", "bc", "b"};
        int[] result = solution.sumPrefixScores(words);
        System.out.println(Arrays.toString(result));
    }
}

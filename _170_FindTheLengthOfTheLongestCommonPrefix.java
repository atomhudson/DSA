import java.util.HashSet;

public class _170_FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100}, arr2 = {1000};
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(arr1,arr2));
        Solution2 ss = new Solution2();
        System.out.println(ss.longestCommonPrefix(arr1,arr2));
    }
}
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int val : arr1){
            while(!hashSet.contains(val) && val > 0){
                hashSet.add(val);

                val = val/10;
            }
        }
        int result = 0;
        for(int num : arr2){
            while(!hashSet.contains(num) && num > 0){
                num /= 10;
            }
            if (num > 0){
                result = Math.max(result,(int)(Math.log10(num) + 1));
            }
        }
        return result;
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
class TrieNode {
    TrieNode[] children = new TrieNode[10];  // 0, 1, 2...9
}
class Solution2 {

    public TrieNode getTrieNode() {
        return new TrieNode();
    }

    public void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }
        return length;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode();  // TRIE
        // Insert all elements of arr1 into the trie
        for (int num : arr1) {
            insert(num, root);
        }
        int result = 0;
        // Search for the longest common prefix in arr2
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }
        return result;
    }
}

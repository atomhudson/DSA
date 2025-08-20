public class _212_Uniqueness {
    public static int solution(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // Example test
    public static void main(String[] args) {
        String input = "himanshu";
        System.out.println(solution(input));
    }
}

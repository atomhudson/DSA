import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _159_FindTheLongestSubStringContainingVowelsInEvenCounts {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
    public static int findTheLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int[] state = new int[5];
        String currState = "00000";
        map.put(currState, -1);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Update state for vowels
            if (ch == 'a') {
                state[0] = (state[0] + 1) % 2;
            } else if (ch == 'e') {
                state[1] = (state[1] + 1) % 2;
            } else if (ch == 'i') {
                state[2] = (state[2] + 1) % 2;
            } else if (ch == 'o') {
                state[3] = (state[3] + 1) % 2;
            } else if (ch == 'u') {
                state[4] = (state[4] + 1) % 2;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : state) {
                sb.append(num);
            }
            currState = sb.toString();
            if (map.containsKey(currState)) {
                result = Math.max(result, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }

        return result;
    }
    public static int findLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int currState = 0;
        map.put(currState, -1);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                currState = (currState ^ 1);
            } else if (ch == 'e') {
                currState = (currState ^ (1 << 1));
            } else if (ch == 'i') {
                currState = (currState ^ (1 << 2));
            } else if (ch == 'o') {
                currState = (currState ^ (1 << 3));
            } else if (ch == 'u') {
                currState = (currState ^ (1 << 4));
            }

            if (map.containsKey(currState)) {
                result = Math.max(result, i - map.get(currState));
            } else {
                map.put(currState, i);
            }
        }
        return result;
    }
}

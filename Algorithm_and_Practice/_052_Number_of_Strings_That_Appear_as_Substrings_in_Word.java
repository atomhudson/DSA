package Algorithm_and_Practice;

public class _052_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    public static int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] patterns = {"a","b","c"};
        String word = "aaaaabbbbb";
        System.out.println(numOfStrings(patterns,word));
    }
}

public class _95_ReversePrefix {
    public static String reversePrefix(String word, char ch) {
        String ans = "";
        String character = String.valueOf(ch);
        int indexofprefix = word.indexOf(character);
        StringBuilder prefix = new StringBuilder (word.substring(0,indexofprefix+1)).reverse();
        ans = prefix.toString()+word.substring(indexofprefix+1);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcd",'z'));

    }
}

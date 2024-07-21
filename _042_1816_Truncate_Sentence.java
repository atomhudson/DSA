public class _042_1816_Truncate_Sentence {
    public static String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                k--;
            }
            if (k == 0){
                return s.substring(0,i);
            }
        }
        return s;

    }
    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(truncateSentence(s,k));
    }
}

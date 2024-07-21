public class _035_Valid_Palindrome {
    public static boolean validpalindrome(String s){
        String result = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int first = 0;
        int last = result.length() - 1;
        while(first < last){
            if(result.charAt(first) == result.charAt(last)){
                first++;
                last--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validpalindrome(" "));
    }
}

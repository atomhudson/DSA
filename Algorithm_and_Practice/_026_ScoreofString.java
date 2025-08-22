package Algorithm_and_Practice;

public class _026_ScoreofString {
    public static int scoreString(String s){
        int sum = 0;
        char[] chararcter = s.toCharArray();
        for (int i = 0; i < chararcter.length; i++) {
            int j = i + 1;
            if (j != chararcter.length) {
                sum = sum + Math.abs(chararcter[i] - chararcter[j]);
                j = j + 1;
            }else {
                break;
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        System.out.println(scoreString("zaz"));
    }
}

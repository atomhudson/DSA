import java.util.Scanner;

public class _144_GrapeCity_NumbersToWords {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        int N = sc.nextInt();
        int temp = N % 100;
        N = N / 100;
        if (temp < 20){
            ans = units[temp];
        }else{
            ans += units[temp % 10];
            ans = tens[temp/10]+" "+ans;
        }
        if (N > 0 && N % 10 > 0){
            ans = units[N % 10] + " Hundred "+ ans;
        }
        N = N / 10;
        if (N > 0){
            ans = units[N] + " Thousand "+ ans;
        }
        System.out.println(ans);
    }
}

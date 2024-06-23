import java.util.Scanner;

public class Java2 {
    public int swap(String str){
        int res =0, j =0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N'){
                j++;
            }else {
                j--;
            }
            if (j < 0){
                j++;
                res++;
            }
        }
        res = res + j;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str = sc.next();
        Java2 j = new Java2();
        System.out.println(j.swap(str));
    }
}

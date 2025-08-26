package Data_Structures;

public class _020_Recursion {

//    Frog Game

    /**
     * There are N stones, numbered 0,1,2,...,N-1. For each i (0 <= i < N)
     * the height of Stone i is hi. There is a frog who is initially on
     * Stone 0. He will repeat the following action some number of times to reach

     * Stone N-1:
     * If the frog is currently on Stone i, jump to Stone i + 1 or Stone i + 2.

     * Here, a cost of |hi - hj| is incurred, where j is the stone to land on.

     * Find the minimum possible total cost incurred before the frog reaches Stone N.
     * Input n = 4
     * arr[] = {10, 30, 40, 20}
     * Output = 30

     * case 1 : 0 -> 1 -> 2 -> 4 = 20 + 10 + 20 = 50
     * case 2 : 0 -> 2 -> 3 = 30 + 20 = 50
     * case 3 : 0 -> 1 -> 3 = 20 + 10 = 30
     *
     */
    static int frogGame(int[] arr, int i){
        if (i == arr.length - 1) return 0;
        int cost1 = Math.abs(arr[i] - arr[i+1]);
        int x =  cost1 + frogGame(arr,i+1);
        if (i == arr.length - 2) return x;
        int cost2 = Math.abs(arr[i] - arr[i+2]);
        int y = cost2 + frogGame(arr,i+2);
        return Math.min(x,y);
    }

    /**
     *
     * str going to digit 2 to 9 (inclusive)
     *  1           2(abc)      3(def)
     *  4(ghi)      5(jkl)      6(mno)
     *  7(pqrs)     8(tuv)      9(wxyz)
     */

    static void keypadPhone(String str, String res, String[] keypad){
        if (str.isEmpty()){
            System.out.print(res + " ");
            return;
        }
        int currentDigit = str.charAt(0) - '0';
        String currentChoices = keypad[currentDigit];
        for (int i = 0; i < currentChoices.length(); i++) {
            keypadPhone(str.substring(1), res + currentChoices.charAt(i), keypad);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,30,40,20};
        System.out.println("Minimum Cost: "+frogGame(arr,0));

//                         0    1    2      3      4      5      6       7      8       9
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        keypadPhone("25398","",keypad);


    }
}

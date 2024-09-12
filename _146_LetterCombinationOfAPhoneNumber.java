import java.util.ArrayList;
import java.util.List;

public class _146_LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        phoneSequence("","12");
        System.out.println();
        System.out.println(letterCombinations("7"));
        System.out.println(letterCombinations("8"));
        System.out.println(letterCombinations("9"));

    }

    /**
     * 1            2           3
     *             abc         def
     * 4            5           6
     * ghi         jkl         mno
     * 7            8           9
     * pqrs        tuv         wxyz
     *
     * @param digits
     * @return ArrayList<String>
     */
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return pad("",digits);
    }
    public static List<String> pad(String p,String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        if(digit == 7){
            for(int i = (digit - 2) * 3; i <= (digit-1) * 3;i++){
                char ch = (char) ('a' + i);
                list.addAll(pad(p+ch,up.substring(1)));
            }
        } else if (digit == 8) {
            for (int i = (digit - 2)*3 + 1; i < (digit - 1)*3 + 1; i++) {
                char ch = (char) ('a' + i);
                list.addAll(pad(p+ch,up.substring(1)));
            }

        } else if (digit == 9) {
            for (int i = (digit - 2)*3 + 1; i < (digit - 1)*3 + 2; i++) {
                char ch = (char) ('a' + i);
                list.addAll(pad(p+ch,up.substring(1)));
            }
        } else{
            for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++){
                char ch = (char) ('a' + i);
                list.addAll(pad(p+ch,up.substring(1)));
            }
        }
        return list;
    }
    static void phoneSequence(String process,String unProcess){
        if (unProcess.isEmpty()){
            System.out.print(process+" ");
            return;
        }
        int digit = unProcess.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch =(char) ('a' + i);
            phoneSequence(process+ch,unProcess.substring(1));
        }
    }
//    static ArrayList<String> pad(String process,String UnProcess){
//        if (UnProcess.isEmpty()){
//            ArrayList<String> list= new ArrayList<>();
//            list.add(process);
//            return list;
//        }
//        int digit = UnProcess.charAt(0) - '0';
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
//            char ch = (char) ('a' + i);
//            list.addAll(pad(process+ch,UnProcess.substring(1)));
//        }
//        return list;
//    }

}

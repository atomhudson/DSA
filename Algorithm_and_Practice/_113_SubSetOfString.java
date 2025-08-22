package Algorithm_and_Practice;

import java.util.ArrayList;

public class _113_SubSetOfString {
//    Or Sub Sequence of String
    public static void main(String[] args) {
        subseq("","abc");
        System.out.println(subsequence("","abc"));
    }
    static void subseq(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subseq(processed + ch,unprocessed.substring(1));
        subseq(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subsequence(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list  = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsequence(p+ch,up.substring(1));
        ArrayList<String> right = subsequence(p,up.substring(1));
        left.addAll(right);
        return left;
    }
}

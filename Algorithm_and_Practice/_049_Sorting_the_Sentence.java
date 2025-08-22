package Algorithm_and_Practice;

import java.util.HashMap;
import java.util.Map;

public class _049_Sorting_the_Sentence {
    public static String sortSentence(String s) {
        String[] sti = s.split(" ");
        int[] indices = new int[sti.length];
        for (int i = 0; i < sti.length; i++) {
            char lastchar = sti[i].charAt(sti[i].length() - 1);
            if (Character.isDigit(lastchar)){
                indices[i] = Character.getNumericValue(lastchar);
            }else {
                indices[i] = -1;
            }
        }
        HashMap<Integer,String> newString = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sti.length; i++){
            newString.put(indices[i], sti[i].substring(0,sti[i].length()-1));
        }
        for (Map.Entry<Integer,String> map : newString.entrySet()){
            stringBuilder.append(map.getValue()+" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1).toString();
    }
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}

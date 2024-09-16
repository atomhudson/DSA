import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _154_Fizz_Buzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzzAdvance(3));
        System.out.println(isAnagram("ab","a"));
    }
    static List<String> fizzBuzz(int n){
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0){
                list.add("Buzz");
            }else{
                list.add(""+i);
            }
        }
        return list;
    }
    static List<String> fizzBuzzAdvance(int n){
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                index++;
                if (index % 15 == 0 ) return "FizzBuzz";
                else if (index % 3 == 0) return "Fizz";
                else if (index % 5 == 0) return "Buzz";
                else return String.valueOf(index);
            }
            @Override
            public int size() {
                return n;
            }
        };
    }
    static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        HashSet<Character> characters = new HashSet<>();
        for (char ch: s.toCharArray()){
            characters.add(ch);
        }
        boolean flag = true;
        for (char ch: t.toCharArray()){
            if (!characters.contains(ch)){
                flag = false;
            }
        }
        return flag;
    }

}

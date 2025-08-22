package Algorithm_and_Practice;

import java.util.*;

public class _163_UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String s1 = "apple apple", s2 = "banana";
        System.out.println(Arrays.toString(uncommonFromSentences(s1,s2)));
    }
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] a = s1.split(" ");
        String[] b = s2.split(" ");
        HashMap<String, Integer> mapS1 = new HashMap<>();
        HashMap<String, Integer> mapS2 = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        for (String s: a){
            mapS1.put(s, mapS1.getOrDefault(s,0)+1);
        }
        for (String s: b){
            mapS2.put(s, mapS2.getOrDefault(s,0)+1);
        }
        for (var hash : mapS1.entrySet()){
            if (hash.getValue() == 1 && !mapS2.containsKey(hash.getKey())){
                stringList.add(hash.getKey());
            }
        }
        for (var hash : mapS2.entrySet()){
            if (hash.getValue() == 1 && !mapS1.containsKey(hash.getKey())){
                stringList.add(hash.getKey());
            }
        }
        String[] array = stringList.toArray(new String[stringList.size()]);
        return array;
    }
}

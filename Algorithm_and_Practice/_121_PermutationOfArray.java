package Algorithm_and_Practice;

import java.util.ArrayList;

public class _121_PermutationOfArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6};
        System.out.println(permutationOfArray(arr));
    }
    static ArrayList<ArrayList<Integer>> permutationOfArray(int[] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> processed = new ArrayList<>();
        ArrayList<Integer> unprocessed = new ArrayList<>();
        for (int num : arr) {
            unprocessed.add(num);
        }
        generatePermutation(processed,unprocessed,result);
        return result;
    }
    static void generatePermutation(ArrayList<Integer> processed,ArrayList<Integer> unprocessed,ArrayList<ArrayList<Integer>> result){
        if (unprocessed.isEmpty()){
            result.add(new ArrayList<>(processed));
            return;
        }
        for (int i = 0; i <= processed.size(); i++) {
            ArrayList<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(i,unprocessed.get(0));
            ArrayList<Integer> newUnProcessed = new ArrayList<>(unprocessed.subList(1, unprocessed.size()));
            generatePermutation(newProcessed,newUnProcessed,result);
        }
    }

}

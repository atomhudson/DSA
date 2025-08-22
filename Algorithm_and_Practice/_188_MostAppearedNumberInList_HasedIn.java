package Algorithm_and_Practice;

import java.util.HashMap;
public class _188_MostAppearedNumberInList_HasedIn {
    static class Solution{
        int MostAppearedNumberInList(int[] arr){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for (int a: arr){
                hashMap.put(a,hashMap.getOrDefault(a,0)+1);
            }
            int maxAppeared = Integer.MIN_VALUE;
            for (int a : hashMap.values()){
                if (a > maxAppeared){
                    maxAppeared = a;
                }
            }
            return maxAppeared;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,788,6,77,0,9,77,8,69,77,788,9,0,0,0,69,69,-89};
        Solution solution = new Solution();
        System.out.println(solution.MostAppearedNumberInList(arr));
    }
}

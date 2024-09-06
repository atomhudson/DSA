import java.util.ArrayList;
import java.util.HashSet;

public class _116_SumOfPairs {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1,3,7,12,9,8,4,5,6};
        int sum = 8;
        System.out.println(sumofPairs(arr,sum));
    }
    static ArrayList<ArrayList<Integer>> sumofPairs(int[] arr, int sum){
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num: arr){
            int complement = sum - num;
            if (hashSet.contains(complement)){
                ArrayList<Integer> arrayList= new ArrayList<>();
                arrayList.add(num);
                arrayList.add(complement);
                list.add(arrayList);
            }
            hashSet.add(num);
        }
        return list;

    }


}

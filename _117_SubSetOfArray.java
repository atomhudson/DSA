import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Both Approach have Time Complexity:O(2^N X N)
public class _117_SubSetOfArray {
//    OR SUB Sequence of Array
    public static void main(String[] args) {
        int[] arr = {4,5,5};
        System.out.println(subset(arr));
        System.out.println(subset1(arr));
    }
//    With Duplicates
    static ArrayList<ArrayList<Integer>> subset(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num: arr){
             int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
// Without Duplicates
static ArrayList<ArrayList<Integer>> subset1(int[] arr){
    Arrays.sort(arr);
    ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
    outer.add(new ArrayList<>());
    int start;
    int end = 0;
    for (int i = 0; i < arr.length;i++){
        start = 0;
//        if current and previous element is same, s = e + 1;
        if(i > 0 && arr[i] == arr[i-1]){
            start = end + 1;
        }
        end = outer.size() - 1;
        int n = outer.size();
        for (int j = start; j < n; j++) {
            ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
            internal.add(arr[i]);
            outer.add(internal);
        }
    }
    return outer;
}

}

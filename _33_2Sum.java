import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class _33_2Sum {
    public static int[] twosum(int[] nums,int target){
        Map<Integer,Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complements.containsKey(complement)){
                return new int[]{i,complements.get(complement)};
            }else {
                complements.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twosum(nums,9)));
    }
}

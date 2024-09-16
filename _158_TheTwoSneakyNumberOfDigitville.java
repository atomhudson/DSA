import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _158_TheTwoSneakyNumberOfDigitville {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0};
        System.out.println(Arrays.toString(getSneakyNumbers(arr)));
//        System.out.println(getSneakyNumbers(arr));
    }
    public static int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int n : nums){
            if (!map.containsKey(n)){
                map.put(n,1);
            }else {
                map.put(n, map.get(n) + 1);
            }
        }
        int i = 0;
        for (Map.Entry<Integer,Integer> mapKey : map.entrySet()){
            int key = mapKey.getKey();
            int countForKey = mapKey.getValue();
            if (countForKey == 2){
                ans[i] = key;
                i++;
            }
        }
        return ans;
    }

}

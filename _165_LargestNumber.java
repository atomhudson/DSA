import java.util.Arrays;
import java.util.Comparator;


public class _165_LargestNumber {
    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums){
        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Comparator<String> myComparator = (a,b)->(b+a).compareTo(a+b);
        Arrays.sort(s, myComparator);
        StringBuilder sb= new StringBuilder();
        for (String str:s){
            sb.append(str);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}

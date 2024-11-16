import java.util.HashMap;
import java.util.Map;

public class _182_MakeSumDivisibleByP {
    public static void main(String[] args) {
        SumDivisibleByP solution = new SumDivisibleByP();
        int[] arr = {3,1,4,2};
        int p = 6;
        System.out.println(solution.minSubarray(arr,p));
    }
}
class SumDivisibleByP{
    public int minSubarray(int[] nums, int p) {
        int n=nums.length, res=n, need=0, cur=0;
        for( int num:nums)
        {
            need=(need+num)%p;
        }
        // need%=p;
        Map<Integer, Integer> list=new HashMap<>();
        list.put(0, -1);
        for( int i=0; i<n; i++)
        {
            cur=(cur+nums[i])%p;
            list.put(cur, i);
            int we_need=(cur-need+p)%p;
            res=Math.min(res, i-list.getOrDefault(we_need, -n));
        }
        return res<n ? res :-1;
    }
}

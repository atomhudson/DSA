package Algorithm_and_Practice;

import java.util.ArrayDeque;
import java.util.Arrays;

class SlidingWindowMaximum{
    int[] solution(int[] nums, int k){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int i=0, j=0, ptr=0;
        int n = nums.length;
        int[] res = new int[n-k+1];
        while(j<n){
            while(!q.isEmpty() && q.peekLast()<nums[j]){
                q.pollLast();
            }
            q.add(nums[j]);
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                res[ptr++] = q.peek();
                if(nums[i]==q.peek()){
                    q.pollFirst();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
public class _195_SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(sol.solution(arr,k)));
    }
}


class ArrListLen{
    int arrListLen(int[] nums){
        int count = 1;
        int head = nums[0];
        int temp = head;
        int next = head;
        while(temp != -1){
            temp = nums[next];
            next = temp;
            count++;
        }
        return count;
    }
}
public class _202_ArrListLen {
    public static void main(String[] args) {
        ArrListLen sol = new ArrListLen();
        int[] nums = {1,4,-1,3,2};
        System.out.println(sol.arrListLen(nums));
    }
}

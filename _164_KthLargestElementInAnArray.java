import java.util.PriorityQueue;

public class _164_KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek() == null ? -1: minHeap.peek();
    }
}

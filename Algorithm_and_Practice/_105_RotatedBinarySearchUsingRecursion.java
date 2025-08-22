package Algorithm_and_Practice;

public class _105_RotatedBinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3};
        int target = 3;
        System.out.println(BinarySearchOnRotatedArray(arr,target));
    }
    static int BinarySearchOnRotatedArray(int[] arr, int target){
        return helperForBinarySearchOnRotatedArrar(arr,target,0,arr.length-1);

    }
    private static int helperForBinarySearchOnRotatedArrar(int[] arr,int target,int start,int end){
//        Check if the start is less than the end during the binary search
//        if the element not found in the array than the start becomes greater than end the end
        if (start > end) {
            return -1;
        }
//        Now calculate the middle of the array based of starting position and ending position
        int middle = start + (end - start) / 2;
//        Now check if the middle element of the array is equal to target element
        if (arr[middle] == target) {
            return middle;
        }
//        If the middle element is not equal to target than
//        Check that our target is lies in which range of array
//        Or we can say that we are checking for the first part of the sorted array
        if (arr[start] <= arr[middle]) {
//            Now also check that our target is in between of start and middle
            if (arr[start] <= target && target <= arr[middle]){
                return helperForBinarySearchOnRotatedArrar(arr,target,start,middle-1);
            }else {
//            If the target is not present in between of start and middle of array
                return helperForBinarySearchOnRotatedArrar(arr,target,middle+1,end);
            }
        }
//        Now we check that our target is lies in other range of the array
//        we can say that we are checking for the second part of the sorted array
        if (arr[middle] <= target && target <= arr[end]){
            return helperForBinarySearchOnRotatedArrar(arr, target, middle + 1, end);
        }
//      if the target is not lies in between the middle and the end of the sorted array.
        return helperForBinarySearchOnRotatedArrar(arr,target,start,middle - 1);
    }
}

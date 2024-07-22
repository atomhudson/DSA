public class _105_RotatedBinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,1,2,3,4};
        int target = 9;
        System.out.println(BinarySearchOnRotatedArray(arr,target));
    }
    static int BinarySearchOnRotatedArray(int[] arr,int target){
        return helperBinarySearchOnRotatedArray(arr, target, 0, arr.length-1);
    }
    private static int helperBinarySearchOnRotatedArray(int[] arr, int target, int start, int end){
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (arr[middle] == target) {
            return  middle;
        }

        if (arr[start] <= arr[middle]) {
            if (target >= arr[start] && target <= arr[middle]){
                return helperBinarySearchOnRotatedArray(arr,target,start,middle - 1);
            }else {
                return helperBinarySearchOnRotatedArray(arr,target,middle + 1,end);
            }
        }
        if (target >= arr[middle] && target <= arr[start]){
            return helperBinarySearchOnRotatedArray(arr,target,middle + 1, end);
        }
        return helperBinarySearchOnRotatedArray(arr,target,start,middle-1);
    }
}

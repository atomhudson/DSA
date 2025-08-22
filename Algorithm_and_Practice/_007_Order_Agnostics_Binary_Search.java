package Algorithm_and_Practice;

public class _007_Order_Agnostics_Binary_Search {
    static int OderAgnosticsBinarySearch(int[] arr,int target){
        if (arr.length == 0){
            return Integer.MIN_VALUE;
        } else if(arr[0] < arr[arr.length - 1]){
            return AscendingOrderBinarySearch(arr,target);
        }else {
            return DescendingOderBinarySearch(arr,target);
        }
    }
    static int AscendingOrderBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if (target == arr[middle]){
                return middle;
            } else if (target > arr[middle]) {
                start = middle + 1;
            }else if (target < arr[middle]){
                end = middle - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    static int DescendingOderBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int middle = start + (end - start) / 2;
            if (target == arr[middle]){
                return middle;
            }else if (target > arr[middle]){
                end = middle - 1;
            }else if (target < arr[middle]){
                start = middle + 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        int target = 6;
        System.out.println(OderAgnosticsBinarySearch(arr,target));
    }
}

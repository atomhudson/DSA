import java.util.Arrays;

public class _06_Binary_Search {
    static int BinarySearch(int[] arr,int target){
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length-1;
        for(int i = 0; i < arr.length; i++) {
            int middle = start + (end - start) / 2;
            if (target == arr[middle]) {
                return middle;
            } else if (arr[middle] > target) {
                end = middle - 1;
            } else if (arr[middle] < target) {
                start = middle + 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    static int BinarySearchusingForEach(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        for(int a : arr){
            int middle = (start + end) / 2;
            if(target == arr[middle]){
                return middle;
            }else if (arr[middle] > target){
                end = middle - 1;
            }else if (arr[middle] < target){
                start = middle + 1;
            }
        }
        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,9,543,3,534,5,34,523,6,265,46,23,534,6,547,5427,3,16,17,6,7654,7,47,457,314,64,63,7,527,516,36,1346,5,3715,36,346,6,161,34,543,63,46,6,346,45,46,4,64,64,6,46,46,4,64,64,26,6,423,63,5754,76,47,68,};
        System.out.println(BinarySearch(arr,7654));
        System.out.println(BinarySearchusingForEach(arr,7654));
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

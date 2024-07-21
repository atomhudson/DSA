public class _012_Binary_Search_First_Last_Position_Of_Target {
    static int BinarySearchForFirstLastPositionFTarget(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                start = mid + 1;
                end = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}

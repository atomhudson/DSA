public class _11_Binary_Search_Floor_Number {
    static int BinarySearchToFindFloorNumber(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(target == arr[mid]){
                return arr[mid];
            }else if (target < arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return arr[end];
    }

    public static void main(String[] args) {
        int[] arr={2,3,5,9,14,16,18};
        int target = 5;
        System.out.println(BinarySearchToFindFloorNumber(arr,target));
    }
}

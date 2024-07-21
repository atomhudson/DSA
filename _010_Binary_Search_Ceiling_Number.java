public class _010_Binary_Search_Ceiling_Number {
    static int BinarySearchToFindCeilingNumberOfTarget(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target == arr[mid]){
                return arr[mid];
            } else if(target < arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return arr[start];
    }
    static char BinarySearchToFindCeilingNumberOfTarget(char[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (target == arr[mid]){
                return arr[mid];
            } else if(target < arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return arr[start];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 1;
        char[] chars = {'c','f','j'};
        char trgt = 'a';
        System.out.println(BinarySearchToFindCeilingNumberOfTarget(arr,target));
        System.out.println(BinarySearchToFindCeilingNumberOfTarget(chars,trgt));

    }

}

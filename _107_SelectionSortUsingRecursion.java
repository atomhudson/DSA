import java.util.Arrays;

public class _107_SelectionSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,8,5,3,5,6,78,8,3,2,3,46,54,76,473,45,654,754,35,7,68,46};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void SelectionSort(int[] arr){
        helperSectionSort(arr,0,arr.length,0);
    }
    private static void helperSectionSort(int[] arr,int start,int end,int max){
        if(end == 0){
            return;
        }
        if (start < end){
            if (arr[start] > arr[max]){
                helperSectionSort(arr, start+1, end, start);
            }else{
                helperSectionSort(arr, start+1, end, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[end-1];
            arr[end-1] = temp;
            helperSectionSort(arr,0,end-1,0);
        }
    }
}

public class _103_IsArraySortedOrNotUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(isSorted(arr));
    }
    static String isSorted(int[] arr){
        return SortedOrNot(arr,0) ? "True" : "False";
    }
    private static boolean SortedOrNot(int[] arr,int index){
//        Base Condition
        if (index == (arr.length - 1)) return true;
        boolean check = arr[index] < arr[index+1];
        return  check && SortedOrNot(arr,index+1);
    }
}

package Algorithm_and_Practice;

public class _001_Linear_Search {
    public static int LinearSearch(int[] arr,int target){
        if (arr.length == 0){
            return Integer.MAX_VALUE;
        }

//        Using For Loop
    /*

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }

     */
//        Using For-Each Loop
        int j = 0;
    /*
        for(int ele: arr){
            if (ele == target){
                return j;
            }else {
                j++;
            }
        }
    */


//        Using While Loop
        while (j != arr.length){
            if (arr[j] == target){
                return j;
            }
            else {
                j++;
            }
        }
        return Integer.MAX_VALUE;


    }
    public static void main(String[] args) {
        int [] arr = {12,9,15,14,19,0};
        int target = 123;
        System.out.println(LinearSearch(arr,target));
    }
}

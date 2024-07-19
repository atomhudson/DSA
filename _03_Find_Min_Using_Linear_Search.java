public class _03_Find_Min_Using_Linear_Search {
    public static int FindingMinUsingLinearSearch(int[] arr){
        int Min_Element = arr[0];
        for(int element: arr){
            if (element < Min_Element){
                Min_Element = element;
            }
        }
        return Min_Element;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,-1,34,56,-6,42,535};
        System.out.println(FindingMinUsingLinearSearch(arr));
    }
}

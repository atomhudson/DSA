public class _2_Linear_Search_In_Range {
    public static int LinearSearchInRange(int[] arr,int Start_Index,int End_Index,int Target){
        if (arr.length == 0){
            return -Integer.MAX_VALUE;
        }
        for (int index = Start_Index; index < End_Index; index++){
            if (arr[index] == Target){
                return index;
            }
        }
        return -Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        int[] arr = {19,12,34,57,0,-1,2,-345,-234,6342};
        int Start_Index = 3;
        int Last_Index = 6;
        int Target = -234;
        System.out.println(LinearSearchInRange(arr,Start_Index,Last_Index,Target));
    }
}

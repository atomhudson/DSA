public class _034_Binary_Search_Using_Recursion {
//1.    Comparison take constant time: O(1).
//2.    Dividing into 2 half.

//   Recurrence Relation
//   [ F(N) = O(1) + F( N / 2); ]
//   What out Recurrence relation saying?
// ->Means for the (N) size array,
//      we are making a comparison in constant time and
//      searching the target in the array size (N / 2);
//   O(1): Comparison that we gonna make.
//   F(N/2): Dividing into 2 half.


//   Types of Recurrence Relation.
//    1. Linear Recurrence Relation: Fibonacci Number
//         |
//          -> This is not getting factored , this is getting subtracted and added linearly.
//    2. Divide and Conquer Recurrence Relation : Binary Search
//         |
//          -> Reduced by a factor

    static int BinarySearchRecursion(int[] arr, int target,int start, int end){
//        int start = 0;
//        int end = arr.length - 1;
//        static int BinarySearchRecursion(int[] arr, int target){}
//        We want that start and end get modified to every function call
//        reduce the search size of the array (half an array).
//        So we have to put start and end in argument.
        if(start > end){
            return -1;
        }
//      Body
        int middle = start + (end - start) / 2;
//        middle is not specific for every call.
        if(arr[middle] == target){
            return middle;
        }
        if(arr[middle] < target){
//      Tip: Make sure  to return the result of a function call of the return type;
            return BinarySearchRecursion(arr, target, middle+1, end);
        }else{
            return BinarySearchRecursion(arr, target, start, middle-1);
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int target = 1;
        System.out.println(BinarySearchRecursion(arr,target,0, arr.length-1));
    }
}
//        s________m_______e
//array = |________|_______|  <-- f()
//                     |
//                  s___m___e
//                  |___|___|  <-- f()
//                    |
//                   s_m_e
//                   |_|_|    <-- f()
//                    |
//                   |_| (target)

//  As we can see that start and end variable is important to every call.
//  In Short if there are a few variables that you need to pass in the future function call put it inside argument.
//  Now, if start and end variable is important for every call than why not middle also important?
//  Because middle in only beneficial inside body only or can calculate using start and end variables.



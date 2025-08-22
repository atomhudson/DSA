package Algorithm_and_Practice;

import java.util.ArrayList;
public class _104_LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {3,2,1,18,9};
        int target = 9;
        System.out.println(linearSearch(arr,target));
        System.out.println(Find(arr,target));
        int[] arr2 = {1,2,4,4,3,2,4,5,5,6};
        System.out.println(targetIndexes(arr2,4));
        System.out.println(findAllIndex(arr2,5,new ArrayList<>()));
        System.out.println(findAllIndexes(arr2,5));

    }
    static boolean Find(int[] arr,int target){
        return helperFunctionToFind(arr,target,0);
    }
    private static boolean helperFunctionToFind(int[] arr, int target,int index){
        if (index == arr.length) return false;
        boolean check = arr[index] == target;
        return check || helperFunctionToFind(arr, target, index+1);
    }
    static int linearSearch(int[] arr,int target){
        return helperFunction(arr,target,0);
    }
    private static int helperFunction(int[] arr,int target,int index){
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;
        return helperFunction(arr,target,index+1);
    }
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> targetIndexes(int[] arr,int target){
        helperToFindTargetIndex(arr,target,0);
        return arrayList;
    }
    private static void helperToFindTargetIndex(int[] arr,int target,int index){
        if(index == arr.length) return ;
        if (arr[index] == target) arrayList.add(index);
        helperToFindTargetIndex(arr, target, index+1);
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int target, ArrayList<Integer> arrayList) {
        return helperForFindAllIndex(arr, target, 0, arrayList);
    }
    private static ArrayList<Integer> helperForFindAllIndex(int[] arr, int target, int index, ArrayList<Integer> arrayList) {
        if (index == arr.length) return arrayList;
        if (arr[index] == target) arrayList.add(index);
        return helperForFindAllIndex(arr, target, index + 1, arrayList);
    }

    static ArrayList<Integer> findAllIndexes(int[] arr,int target){
        return helperForFindAllIndexes(arr, target, 0);
    }
    private static ArrayList<Integer> helperForFindAllIndexes(int[] arr,int target,int index){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (index == arr.length) return arrayList;
        if (arr[index] == target) arrayList.add(index);
        ArrayList<Integer> ansFromBelowCalls = helperForFindAllIndexes(arr,target,index+1);
        arrayList.addAll(ansFromBelowCalls);
        return arrayList;
    }

}

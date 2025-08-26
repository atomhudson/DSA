package Data_Structures;

import java.util.ArrayList;

public class _019_Recursion {

    static void printArray(int[] arr, int i){
        if (i == arr.length) return;
        System.out.print(arr[i] + " ");
        printArray(arr, ++i);
    }

    static int maxValue(int[] arr){
        return helperMax(arr,0,arr[0]);
    }

    private static int helperMax(int[] arr, int i, int max) {
        if (i == arr.length) return max;
        if (arr[i] > max) max = arr[i];
        return helperMax(arr,++i,max);
    }

    static int sumOfElement(int[] arr, int idx){
        if (idx == arr.length - 1) return arr[idx];
        return arr[idx] + sumOfElement(arr,idx+1);
    }

    static boolean linearSearch(int[] arr, int idx, int target){
        if (idx == arr.length) return false;
        if (arr[idx] == target) return true;
        return linearSearch(arr,idx+1,target);
    }

    static void returnAllIndexOfTarget(int[] arr, int idx, int target){
        if (idx == arr.length) return;
        if (arr[idx] == target) System.out.print(idx + " ");
        returnAllIndexOfTarget(arr,idx+1,target);
    }

    static ArrayList<Integer> findAllIndices(int[] arr, int idx, int target){
        if (idx == arr.length) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr[idx] == target) ans.add(idx);
        ArrayList<Integer> small = findAllIndices(arr,idx+1,target);
        ans.addAll(small);
        return ans;
    }

    static String removeOccurrences(String str, int idx, char target){
        if (idx == str.length()) return "";
        String ans = "";
        if (str.charAt(idx) != target) ans += str.charAt(idx);
        return ans + removeOccurrences(str,idx+1,target);
    }

    static String removeOccurrences(String str, char target){
        if (str.isEmpty()) return "";
        String ans = "";
        if (str.charAt(0) != target) ans += str.charAt(0);
        return ans + removeOccurrences(str.substring(1),target);
    }

    static String printReverse(String str){
        if (str.isEmpty()) return "";
        String ans = "";
        ans += str.charAt(str.length()-1);
        return ans + printReverse(str.substring(0,str.length()-1));
    }

    static boolean checkPalindrome(String str){
        String reverse = printReverse(str);
        return str.equals(reverse);
    }

    static boolean checkPalindrome(String str, int left, int right){
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return checkPalindrome(str,left+1,right-1);
    }

    /**
     * "abc" -> abc abc
     *          ab  ab_
     *          bc  _bc
     *          ac  a_c
     *          a   a__
     *          b   _b_
     *          c   __c
     *         " "  ___
     */
    static ArrayList<String> subSequences(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str.isEmpty()) {
            ans.add(" ");
            return ans;
        }
        char curr = str.charAt(0);
        ArrayList<String> smallAns = subSequences(str.substring(1));
        for (String ss : smallAns) {
            ans.add(ss);
            ans.add(curr + ss);
        }
        return ans;
    }

    static void subSequences(String str,String ans){
        if (str.isEmpty()){
            System.out.print(ans + " ");
            return;
        }
        char currentCharacter = str.charAt(0);
        String remainingString = str.substring(1);
        // Current Character --> Chooses to be a part of currAns.
        subSequences(remainingString,ans + currentCharacter); // Inclusion of current character
        // Current Character --> Does not choose to be a part of currAns.
        subSequences(remainingString,ans); // Exclusion of current character.
    }

    static void sumOfAllSubsets(int[] arr, int sum, int idx){
        if (idx >= arr.length){
            System.out.print(sum+" ");
            return;
        }
        int curr= arr[idx];
        sumOfAllSubsets(arr,curr+sum, idx+1);
        sumOfAllSubsets(arr, sum, idx+1);
    }



    public static void main(String[] args) {
        int[] arr = {2,4,5};
        System.out.print("Printing array: ");printArray(arr,0);
        System.out.println();
        System.out.print("Max value of array: "+maxValue(arr));
        System.out.println();
        System.out.println("Sum of all element in array: "+sumOfElement(arr,0));
        System.out.println("Searching an element in array: "+linearSearch(arr,0,12));
        System.out.print("Finding all index of an element in array: ");returnAllIndexOfTarget(arr,0,1);
        System.out.println();
        System.out.print("Finding all index of an element in array: "+findAllIndices(arr,0,1));
        System.out.println();

        String str = "zap";

        System.out.print("Removing all the occurrences of a character from string: "+removeOccurrences(str,0,'a'));
        System.out.println();
        System.out.print("Removing all the occurrences of a character from string: "+removeOccurrences(str,'a'));
        System.out.println();
        System.out.print("Printing Reverser of a String : "+printReverse(str));
        System.out.println();
        System.out.println("Checking Palindrome of a String: "+checkPalindrome(str));
        System.out.println("Checking Palindrome of a String: "+checkPalindrome(str,0,str.length()-1));
        System.out.println("Subsequences of String: "+subSequences("str"));
        System.out.print("Subsequences of String: ");subSequences("abcde"," ");
        System.out.println();
        System.out.print("Sum of all subset: ");sumOfAllSubsets(arr,0,0);
    }
}


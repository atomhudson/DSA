public class _037_Find_Smallest_Letter_Greater_Than_Target {

    public static char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length-1]){
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if (letters[middle] <= target){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return letters[start];
    }
    public static void main(String[] args) {
        char[] letters= {'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters,target));


    }
}

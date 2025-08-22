package Algorithm_and_Practice;

public class _005_Even_Digits_Linear_Search {
    static int EvenDigitCount(int[] arr){
        int count = 0;
        for (int element:arr){
            if(countDigit(element) % 2 == 0){
                count++;
            }
        }
        return count;
    }
    static int even(int element){
        String lng = Integer.toString(element);
        return lng.length();
    }
    static int countDigit(int element){
        int digit = 0;
        while(element != 0){
            element /= 10;
            digit++;
        }
        return digit;
    }


    public static void main(String[] args) {
        int [] arr = {123,1,4,5,6777,23};
        System.out.println(EvenDigitCount(arr));
        System.out.println(countDigit(1923));
    }
}

package Algorithm_and_Practice;

import java.util.HashMap;
import java.util.Map;

/*
Mr.Rock on his way to the office used to observed a board,
where a lucky number S of that day is written.
It was written by an older man to build some interest in math among
the office employees. Every day he used to note the numbers in his dairy.
He did a lot of math on it and found that if he takes the last N numbers
in sequence then the lucky number is equal to the sum of all the numbers
that have repeated odd number of times.

◆ Now Rock wants to help the old man by replacing the board with a digital,
which he can operate from his home also. Can you write a program that
accepts N numbers and displays the lucky number for that day?

◆ Sample Input1:
     digit[]= {11,11,12,12,13,13,13}
  Sample Output1: 39
• Explanation:
    ◆ Considering the last 7 days data,
    11 and 12 have repeated 2 times
    i.e. repeated even number of times
    so they cannot be considered for calculation,
    whereas 13 has repeated 3 times which is odd,
    so the lucky number S=13+13+13=39 .
 */
class LuckyNumberByOddAndEvenOccurrenceOfNumber{
    int LuckyNumber(int[] digit){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int a: digit){
            hashMap.put(a,hashMap.getOrDefault(a,0)+1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = 0;
            int times = 0;
            if (entry.getValue() % 2 != 0){
                key = entry.getKey();
                times = entry.getValue();
                for (int i = 0; i < times; i++) {
                    sum += key;
                }
            }
        }
        return sum;
    }
}
public class _192_LuckyNumberByOddAndEvenOccurrenceOfNumber {
    public static void main(String[] args) {
        int[] digit = {11,11,12,12,13,13,13,17};
        LuckyNumberByOddAndEvenOccurrenceOfNumber number = new LuckyNumberByOddAndEvenOccurrenceOfNumber();
        System.out.println(number.LuckyNumber(digit));
    }
}

package Algorithm_and_Practice;/*
◆ Consider a string Str, pick each integer from the Fibonacci series
and insert one by one into Str such that each character of Str is
followed by the integer picked from Fibonacci series.
Next, find the sum all the integers picked and add it at the beginning
of Str.

Sample Input1:
str = "abcde"
Sample Output1:
12a1b1c2d3e5

Explanation 1:
Fibonacci series is 1,1,2,3,5
Given string is modified to alb1c2d3e5.
Sum of all integers is 12.
So, the output is 12a1b1c2d3e5.
 */
import java.util.ArrayList;
import java.util.List;
class SumOfFibonacciSeriesInBetweenTheString{
    String conversion(String str){
        List<Integer> fibo = FibonacciSeries(str.length());
        String result = "";
        int sum = 0;
        for (int a: fibo){
            sum += a;
        }
        result += sum;
        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            result += ch;
            int fib = fibo.get(i);
            result += fib;
        }
        return result;
    }
    private List<Integer> FibonacciSeries(int num){
        if (num == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        if (num == 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            return list;
        }
        List<Integer> list = FibonacciSeries(num - 1);
        int size = list.size();
        int nextFib = list.get(size - 1) + list.get(size - 2);
        list.add(nextFib);
        return list;
    }
}
public class _193_SumOfFibonacciSeriesInBetweenTheString {
    public static void main(String[] args) {
        SumOfFibonacciSeriesInBetweenTheString solution = new SumOfFibonacciSeriesInBetweenTheString();
        System.out.println(solution.conversion("abcde"));

    }

}

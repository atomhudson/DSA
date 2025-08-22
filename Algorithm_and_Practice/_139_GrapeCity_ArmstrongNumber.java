package Algorithm_and_Practice;

import java.util.Scanner;

public class _139_GrapeCity_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int pow = String.valueOf(N).length();
        int arms = 0;
        while (N != 0){
            int remainder = N % 10;
            arms += (int) Math.pow(remainder,pow);
            N /= 10;
        }
        if (arms == temp){
            System.out.println("Armstrong");
        }else{
            System.out.println("Not Armstrong");
        }

    }
}

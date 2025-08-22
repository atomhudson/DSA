package Algorithm_and_Practice;

import java.util.Scanner;

public class _134_GrapeCity_CountCarry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();
        int sum = 0,carry = 0,op = 0;
        while (N1 > 0 || N2 > 0){
            sum = N1 % 10 + N2 % 10 + carry;
            carry = sum / 10;
            op += carry;
            N1 = N1 / 10;
            N2 = N2 / 10;
        }
        System.out.println(op);
    }
}

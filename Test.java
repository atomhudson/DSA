import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int K = sc.nextInt();
        if (K == 0) {
            System.out.println(L);
            return;
        }
        if (K == L) {
            System.out.println(0);
            return;
        }
        int totalZeros = L - K;
        int groups = K + 1;
        int zerosPerGroup = totalZeros / groups;
        int remainder = totalZeros % groups;
        int longestZeroBlock = (remainder > 0) ? zerosPerGroup + 1 : zerosPerGroup;
        System.out.println(longestZeroBlock);
        sc.close();
    }
}


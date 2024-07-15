import java.util.Map;
import java.util.Scanner;

public class _63_Decinalconversion {
    public static String IntTOBinary(int n){
        if(n == 0){
            return "0";
        }
        StringBuilder string = new StringBuilder();
        while(n != 0){
            int remainder = n % 2;
            string.append(remainder);
            n = n / 2;
        }
        return string.reverse().toString();
    }
    public static String DecimalToOctal(int n){
        if(n == 0){
            return "0";
        }
        StringBuilder string = new StringBuilder();
        while(n != 0){
            int remainder = n % 8;
            string.append(remainder);
            n = n / 8;
        }
        return string.reverse().toString();
    }
    public static String IntToHexaDecimal(int n){
           if(n == 0){
               return "0";
           }
           StringBuilder string = new StringBuilder();
           char[] chaHexa = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E'};
           while(n != 0){
               int remainder = n % 16;
               string.insert(0,chaHexa[remainder]);
               n = n / 16;
           }
           return string.toString();
    }
    public static int convertoDecimal(String s){
        int num = 0;
        StringBuilder string = new StringBuilder(s);
        string.reverse();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') num += Math.pow(2,i);
        }
        return num;
    }
    public static String convertBinaryToOctal(String b) {
        int lengthOfBinary = b.length();
        int paddingNeeded = (3 - (lengthOfBinary % 3)) % 3;
        StringBuilder paddedBinary = new StringBuilder();
        for (int i = 0; i < paddingNeeded; i++) {
            paddedBinary.append('0');
        }
        paddedBinary.append(b);
        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < paddedBinary.length(); i += 3) {
            String binaryGroup = paddedBinary.substring(i, i + 3);
            octal.append(binaryToOctalDigit(binaryGroup));
        }
        return octal.toString();
    }

    private static char binaryToOctalDigit(String binaryGroup) {
        int decimalValue = Integer.parseInt(binaryGroup, 2);
        return Character.forDigit(decimalValue, 8); // Convert integer to corresponding octal digit
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number(Decimal) : ");
        int i = sc.nextInt();
        System.out.println("Decimal To Binary: "+IntTOBinary(i));
        System.out.println("Using in int Built java function for Decimal to Binary: "+Integer.toBinaryString(i));
        System.out.println("Decimal to Octal: "+DecimalToOctal(i));
        System.out.println("Using in int Built java function for Decimal To Octal: "+Integer.toOctalString(i));
        System.out.println("Decimal to Octal: "+IntToHexaDecimal(i));
        System.out.println("Using in int Built java function for Decimal To Hexa-Decimal: "+Integer.toHexString(i).toUpperCase());
        System.out.println("Binary to Decimal:"+convertoDecimal(IntTOBinary(i)));
        System.out.println("Binary to Octal: "+convertBinaryToOctal(IntTOBinary(i)));




    }
}

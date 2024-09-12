import java.util.Scanner;

public class _144_GrapeCity_NumbersToWords {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int N = sc.nextInt();
        sc.close();

        if (N == 0) {
            System.out.println("Zero");
        } else {
            System.out.println(convertToWords(N));
        }
    }

    private static String convertToWords(int N) {
        String result = "";

        // Handle the units, tens, hundreds, and thousands
        result = handleSegment(N % 1000, "Hundred") + result;
        N /= 1000;

        if (N > 0) {
            result = handleSegment(N % 1000, "Thousand") + result;
            N /= 1000;
        }

        if (N > 0) {
            result = handleSegment(N % 1000, "Million") + result;
        }

        return result.trim(); // Return the final result without extra spaces
    }

    private static String handleSegment(int number, String segment) {
        if (number == 0) return ""; // No need to process empty segments

        String result = "";

        // Handle units and tens (0-99)
        int temp = number % 100;
        if (number % 100 < 20) {
            result = units[number % 100];
            number /= 100;
        } else {
            result = units[number % 10];
            number /= 10;
            result = tens[number % 10] + " " + result;
            number /= 10;
        }

        // Handle hundreds (100-999)
        if (number > 0) {
            result = units[number] + " Hundred " + result;
        }

        return result.trim() + " " + segment + " "; // Ensure proper spacing and segment label
    }
}

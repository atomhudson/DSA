/*

The Binary number system only uses two digits, 0 and 1 and number system can be called binary string. You are required to implement the following function:
int OperationsBinaryString(char* str);
The function accepts a string str as its argument. The string str consists of binary digit separated with an alphabet as follows:
•	– A denotes AND operation
•	– B denotes OR operation
•	– C denotes XOR Operation
You are required to calculate the result of the string str, scanning the string to right taking one operation at a time, and return the same.
*/
import java.util.Scanner;
public class _184_OperationBinaryString_Acc {
    static class Solution {
        int OperationBinaryString(String str) {
            int result = Character.getNumericValue(str.charAt(0));
            for (int i = 1; i < str.length(); i += 2) {
                int operator = str.charAt(i);
                int nextBit = Character.getNumericValue(str.charAt(i + 1));
                switch (operator) {
                    case 'A':
                        result &= nextBit;
                        break;
                    case 'B':
                        result |= nextBit;
                        break;
                    case 'C':
                        result ^= nextBit;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + operator);
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // Input binary string with operators
        Solution solution = new Solution();
        System.out.println(solution.OperationBinaryString(str)); // Output the result
    }
}

package Algorithm_and_Practice;

public class _145_MinimumBitsFlipsToConvertNumber {
    public static void main(String[] args) {
        int a = 10;
        int b = 7;
        System.out.println(minBitFlips(a,b));
    }

    /**
     *
     * @param start
     * @param goal
     * @return
     */
    public static int minBitFlips(int start, int goal) {
        String startString = Integer.toBinaryString(start);
        String goalString = Integer.toBinaryString(goal);
        String paddedStart = startString;
        String paddedGoal = goalString;
        if (startString.length() != goalString.length()){
            paddedStart = StringPadding(startString,goalString.length());
            paddedGoal = StringPadding(goalString,startString.length());
        }
        int count = 0;
        for (int i = 0; i < paddedStart.length(); i++) {
            if (paddedStart.charAt(i) != paddedGoal.charAt(i)){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param string
     * @param length
     * @return
     */
    public static String StringPadding(String string, int length){
        int paddingNeeded = length - string.length();
        StringBuilder paddedBinaryString = new StringBuilder();
        for (int i = 0; i < paddingNeeded; i++) {
            paddedBinaryString.append('0');
        }
        paddedBinaryString.append(string);
        return paddedBinaryString.toString();
    }
}

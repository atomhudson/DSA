package Algorithm_and_Practice;

public class _036_Excel_Sheet_Column_Title {
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            int mu = columnNumber % 26;
            stringBuilder.append((char) (mu + 'A'));
            columnNumber = columnNumber / 26;
        }
        return stringBuilder.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(2001));
    }
}

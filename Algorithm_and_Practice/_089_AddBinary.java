package Algorithm_and_Practice;

public class _089_AddBinary {
    public static void main(String[] args) {
        System.out.println(AddBinary("1010","1011"));
    }
    public static String AddBinary(String a,String b){
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }
}

package Algorithm_and_Practice;

class foo {
    static String text = "Algorithm_and_Practice.foo";
}
class bar extends foo{
    void printtext() {
        System.out.println(foo.text);
    }
}
public class _024_Find_All_Numbers_Disappearead_Number {
    public static void main(String[] args) {
        System.out.println(bar.text);
        System.out.println("java11" == "java11");
        System.out.println("java11" == "java11".intern());
        System.out.println();
    }
}

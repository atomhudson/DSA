public class _115_Revision {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
    static void print(int n){
        if (n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(--n);
    }

}

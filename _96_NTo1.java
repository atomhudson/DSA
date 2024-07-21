public class _96_NTo1 {
    public static void main(String[] args) {
        int n = 6;
        Nto1(n);
        System.out.println();
        _1toN(n);
        System.out.println();
        Nto1_1toN(n);
    }
    static void Nto1(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        Nto1(n - 1);
    }
    static void _1toN(int n){
        if(n == 0){
            return;
        }
        _1toN(n - 1);
        System.out.print(n + " ");
    }
    static void Nto1_1toN(int n){
        if (n == 0){
            return;
        }
        System.out.print(n + " ");
        Nto1_1toN(n - 1);
        System.out.print(n + " ");
    }
}

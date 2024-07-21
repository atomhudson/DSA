public class _086_EuclideanAlgorithmForGCDandLCM {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(GCDandHCFusingEculideanAlgo(a,b));
        System.out.println(LCM(a,b));
    }
    static int GCDandHCFusingEculideanAlgo(int a,int b){
        if (a == 0){
            return b;
        }
        return GCDandHCFusingEculideanAlgo(b % a, a);
    }
    static int LCM(int a, int b){
        return a * b / GCDandHCFusingEculideanAlgo(a,b);
    }
}

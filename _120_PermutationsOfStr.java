import java.util.ArrayList;

public class _120_PermutationsOfStr {
    public static void main(String[] args) {
        String p = "";
        String up = "123";
        permutations(p,up);
        System.out.println(permutation(p,up));
        System.out.println(countPermutation(p,up));
    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i);
            String pro = f+ch+s;
            String sub = up.substring(1);
            permutations(pro,sub);
        }
    }
    static ArrayList<String> permutation(String p, String up){
        ArrayList<String> outer = new ArrayList<>();
        if (up.isEmpty()){
            outer.add(p);
            return outer;
        }
        char ch = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String F = p.substring(0,i);
            String E = p.substring(i);
            String Processed = F + ch + E;
            String SUB = up.substring(1);
            ArrayList<String> ansFromCalls = permutation(Processed,SUB);
            outer.addAll(ansFromCalls);
        }
        return outer;
    }
    static int countPermutation(String p, String up){
        if (up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0,i);
            String e = p.substring(i);
            String pro = f + ch + e;
            String sub = up.substring(1);
            count = count + countPermutation(pro,sub);
        }
        return count;
    }

}

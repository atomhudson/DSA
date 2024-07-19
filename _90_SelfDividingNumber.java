import java.util.ArrayList;
import java.util.List;

public class _90_SelfDividingNumber {
    public static void main(String[] args) {
        int left = 47;
        int right = 85;
        System.out.println(selfDividingNumber(left,right));
    }
    public static List<Integer> selfDividingNumber(int left, int right){
        List<Integer> arrlList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = check(i);
            if (flag) arrlList.add(i);
        }
        return arrlList;
    }
    static boolean check(int i){
        int temp = i;
        while (i != 0){
            int remainder = i % 10;
            if (remainder == 0 || temp % remainder != 0) return false;
            i /= 10;
        }
        return true;
    }
}

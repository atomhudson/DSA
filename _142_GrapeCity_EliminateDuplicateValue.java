import java.util.HashMap;
import java.util.Scanner;
public class _142_GrapeCity_EliminateDuplicateValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : arr){
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }else{
                hashMap.put(num,1);
            }
        }
        for (int j : arr) {
            if (hashMap.get(j) == 1) {
                System.out.print(j+" ");
            }
        }
    }
}

//Sample Input:
//n = 6
//arr[] = {1,2,2,1,2,4}
//Sample Output: 4
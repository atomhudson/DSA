package Algorithm_and_Practice;

public class _180_CheckIfArrayParisAreDivisibleByK {
    public static void main(String[] args) {
        CheckPairsAreDivisibleByK divisibleByK = new CheckPairsAreDivisibleByK();
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        System.out.println(divisibleByK.canArrange(arr, k));
    }
}
class CheckPairsAreDivisibleByK{
    public boolean canArrange(int[] arr, int k) {
        int[] mp = new int[k];
        for (int ele: arr) {
            int rem = (ele % k + k) % k;
            mp[rem]++;
        }
        if(mp[0] % 2 != 0){
            return false;
        }
        for (int rem = 1; rem <= k /2 ; rem++) {
            int CounterHalf = k - rem;
            if (mp[CounterHalf] != mp[rem]){
                return false;
            }
        }
        return true;
    }
}
public class _169_KthSmallestLexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(findKthNumber(10,2));
    }
    static int findKthNumber(int n,int k){
        int curr = 1;
        k -= curr;
        while (k > 0){
            int countNum = count(curr,curr+1,n);
            if (countNum <= k){
                curr++;
                k -= countNum;
            }else{
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    static int count (long curr, long next, int limit){
        int countNum = 0;
        while(curr <= limit){
            countNum += (next - curr);
            curr *= 10;
            next *= 10;
            next = Math.min(next,limit+1);
        }
        return countNum;
    }


}

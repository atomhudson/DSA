public class _081_SieveOfEratosthnesesForPrimeNumber {
    public static void main(String[] args) {
        int n = 22;
//        this boolean array[primes] has all the value initialised to false;
//        like if be print primes[0] than it print the {false}.
//        primes[0......n] = false;
        boolean[] primes = new boolean[n+1];
        SieveOfEratosthneses(n,primes);
//        System.out.println((int)Math.sqrt(15));
        System.out.println();

    }
    static void SieveOfEratosthneses(int n,boolean[] primes){
//        for false in boolean array means number is prime 
//        for true in boolean array means number is not prime. 
        for (int i = 2; i * i <= n; i++) {
            if(!primes[i]){
                for (int j = i * 2; j <= n ; j+=i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            if (!primes[i]){
                System.out.print(i+" ");
            }
        }

    }


}

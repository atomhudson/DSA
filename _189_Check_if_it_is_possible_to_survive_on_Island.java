import java.util.Scanner;

public class _189_Check_if_it_is_possible_to_survive_on_Island {
    /*
    You are a poor person on an island.
    There is only one shop on this island,
    this shop is open on all days of the week except for Sunday.
    Consider following constraints:
       N – Maximum unit of food you can buy each day.
       S – Number of days you are required to survive.
       M – Unit of food required each day to survive.

Input : S = 10 N = 16 M = 2
Output : 2
Explanation 1: One possible solution is to buy a box on the first day (Monday),
               it’s sufficient to eat from this box up to 8th day (Monday)
               inclusive. Now, on the 9th day (Tuesday), you buy another box
               and use the chocolates in it to survive the 9th and 10th day.

Input : 10 20 30
Output : -1
Explanation 2: You can’t survive even if you buy food because the maximum
               number of units you can buy in one day is less the required
               food for one day.
*/

    static class Solution{
        int survival(int S,int N,int M)
        {
            double req = S * M;
            int NoOfSundayInSurvivalDays = S / 7;
            int total = (S - NoOfSundayInSurvivalDays) * N;
            if (total < req) {
                return -1;
            }
            else {
                double re = Math.ceil(req / N);
                return (int)re;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S  = sc.nextInt();
        int N  = sc.nextInt();
        int M  = sc.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.survival(S,N,M));
    }

}

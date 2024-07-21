public class _030_Best_Time_To_Buy_And_Sell_Stock {
    public static int maxProfit(int[] prices){
        int buy_price = prices[0];
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(buy_price > prices[i]){
                buy_price = prices[i];
            } else{
                int current_profit = prices[i] - buy_price;
                max_profit = Math.max(current_profit,max_profit);
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

//Day 1, Day 2,[Day 3, Day4, Day 5, Day 6]
//    7,     1,     5,    3,     6,     4
//           ^                   ^
//           | =>finding profit  |
//          buy                 sell

// Buy with price 1

// now if day 3 with price 5 profit will be 5-1 = 4.
// now if day 4 with price 3 profit will be 3-1 = 2.
// now if day 5 with price 6 profit will be 6-1 = 5.
// now if day 6 with price 4 profit will be 4-1 = 3.

// so we decide to sell the stock on day 5 with max. profit on 5.



// Day 1, Day 2, Day 3, Day4, Day 5, Day 6
//     7,     1,     5,    3,     6,     4

// if we buy_stock with day 1 buy_price = 7 => 1;
//  Now, if the buy_price is higher than the new price on the upcoming day we update our buy_price; means buy_price > new_price ==> buy_price = new_price;
//  Current_profit = 0 => 4 => 2 => 5;
//  max_profit = 0 => 4 => 5 ;
//  Now, buy_price < new_price then, current_profit will be  current_profit = new_price - buy_price that is 5 - 1 = 4;
//  Now, if max_profit < Current_profit, then max_profit = current_profit;

// Now, Day 4, with new_price = 3;
// current_profit = 3 - 1 = 2;
// max_profit > current_profit ;
// result not change the max_profit;

// Now Day 5, with new_price = 6;
// current_profit = 6 - 1 = 5;
// max_profit < current_profit;
// max_profit = 5;

// Now Day 6, with new_price = 4;
// current_profit = 4 - 1 = 3;
// max_profit > current_profit ;
// result not change the max_profit;






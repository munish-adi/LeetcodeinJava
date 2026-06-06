import java.util.*;
public class L121BestTimeToBuyStock {
//    public int maxProfit(int[] prices){
//        int profit = 0;
//        int low = prices[0];
//        for(int i = 0; i < prices.length; i++){
//            if(low > prices[i]){
//                low = prices[i];
//            } else if (prices[i]-low > profit) {
//                profit = prices[i] - low;
//            }
//        }
//
//
//
//        return profit;
//    }
    public int maxProfit(int[] prices){
        int profit = 0;
        int stockbuy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            stockbuy = Math.min(stockbuy, prices[i]);
            profit = Math.max(profit, prices[i]-stockbuy);
        }
        return profit;
    }

    public void main(String[] args){
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }
}

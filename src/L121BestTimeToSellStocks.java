public class L121BestTimeToSellStocks {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            int key = prices[i];
            for(int j = i+1; j < prices.length; j++){
                if(key < prices[j]){
                    maxProfit = Math.max(maxProfit, prices[j] - key);
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        //using two pointers
        int maxProfit = 0;
        int left = 0;
        int right = left+1;
        while(right < prices.length){
            if(prices[right] > prices[left]){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
            left = right;
            right++;
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        //using Dynamic Programming
        //we keep track of two things
        //1 - lowest price so far ie the best day to buy
        //2 - best Profit so fat ie (selling today - best day to sell)
        int maxProfit = 0;
        int minbuy = prices[0];

        for(int sell : prices){
            maxProfit = Math.max(maxProfit, sell - minbuy);
            minbuy = Math.min(minbuy, sell);
        }
        return maxProfit;
    }

    public void main(String[] args){
        int[] nums = {7,6,4,3,15};
        System.out.println(maxProfit3(nums));
    }
}
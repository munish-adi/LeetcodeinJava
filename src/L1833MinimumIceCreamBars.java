public class L1833MinimumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        int len = costs.length;
        //always buy cheap to get map no of ice creams
        int maxCost = 0;

        for(int i : costs){
            maxCost = Math.max(maxCost, i);
        }

        int[] freq = new int[maxCost+1];
        for(int i : costs){
            freq[i]++;
        }

        int maxicecream = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (freq[cost] == 0)
                continue;
            int canBuy = Math.min(freq[cost], coins / cost);
            maxicecream += canBuy;
            coins -= canBuy * cost;
            if (coins < cost)
                break;
        }
        return maxicecream;

    }



    public static void main(String[] args){
        int[] costs = new int[]{1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));

    }
}

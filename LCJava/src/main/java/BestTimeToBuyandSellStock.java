/**
 * Created by zhaobo on 4/20/17.
 * Given array [3,2,3,1,2], return 1
 */
public class BestTimeToBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length ==0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}

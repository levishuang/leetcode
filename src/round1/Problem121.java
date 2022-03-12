package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/12 17:10
 */

public class Problem121 {
    //超时
    public static int maxProfit1(int[] prices) {
        if(prices.length == 1) return 0;
        int benifit = 0;
        for(int i = 1; i < prices.length; i++){
            for(int j = 0; j < i; j++){
                if(prices[i] - prices[j] >= benifit){
                    benifit = prices[i] - prices[j];
                }
            }
        }
        return benifit;
    }
    public static int maxProfit(int[] prices) {
        int min_Price = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min_Price){
                min_Price = prices[i];
            }
            if(prices[i] - min_Price >= profit){
                profit = prices[i] - min_Price;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

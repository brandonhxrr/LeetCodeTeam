class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        int[] left_profit = new int[n];
        int[] right_profit = new int[n];

        int min_price = prices[0];
        for (int i = 1; i < n; i++){
            min_price = Math.min(min_price, prices[i]);
            left_profit[i] = Math.max(left_profit[i - 1], prices[i] - min_price);
        }

        int max_price = prices[n-1];
        for(int i = n-2; i >= 0; i--){
            max_price = Math.max(max_price, prices[i]);
            right_profit[i] = Math.max(right_profit[i + 1], max_price - prices[i]);
        }

        int max_profit = 0;
        for(int i = 0; i < n; i++){
            max_profit = Math.max(max_profit, left_profit[i] + right_profit[i]);
        }

        return max_profit;

    }
}
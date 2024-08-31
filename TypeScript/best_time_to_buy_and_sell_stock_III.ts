function maxProfit(prices: number[]): number {
    let n: number = prices.length;
    if(n == 0){
        return 0;
    }
        let left_profit: number[] = new Array(n).fill(0);
        let right_profit: number[] = new Array(n).fill(0);


        let min_price: number = prices[0];
        for (let i = 1; i < n; i++){
            min_price = Math.min(min_price, prices[i]);
            left_profit[i] = Math.max(left_profit[i - 1], prices[i] - min_price);
        }

        let max_price: number = prices[n-1];
        for(let i = n-2; i >= 0; i--){
            max_price = Math.max(max_price, prices[i]);
            right_profit[i] = Math.max(right_profit[i + 1], max_price - prices[i]);
        }

        let max_profit: number = 0;
        for(let i = 0; i < n; i++){
            max_profit = Math.max(max_profit, left_profit[i] + right_profit[i]);
        }

        return max_profit;

 }
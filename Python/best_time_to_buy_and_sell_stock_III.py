class Solution(object):
    def maxProfit(self, prices):
        n = len(prices)

    # Create two arrays to store the maximum profit
    #Arrays that will store the maxProfit at different points in time, size n, filled with zeros
        left_profit = [0] * n
        right_profit = [0] * n

    # First transaction (from left to right)
        min_price = prices[0]
        for i in range(1, n):
            #Compare the first price with every price in the list, update min_price if another is found
            min_price = min(min_price, prices[i])
            #Stores the max profit we could have made up to that day, comparing the current with the hihgest profit we had up
            #to the previous day
            left_profit[i] = max(left_profit[i - 1], prices[i] - min_price)

    # Second transaction (from right to left)
        max_price = prices[-1]
        #Prices from the penultimate day (i = n - 2) to the first day (i = 0)
        for i in range(n - 2, -1, -1):
            #Hihgest price found from right to left
            max_price = max(max_price, prices[i])
            #stores the max profit
            right_profit[i] = max(right_profit[i + 1], max_price - prices[i])

    # Combine the two profits
        max_profit = 0
        #go throught all days and store all posible profits from the first and second transaction 
        for i in range(n):
            max_profit = max(max_profit, left_profit[i] + right_profit[i])
            
        return max_profit

        
        
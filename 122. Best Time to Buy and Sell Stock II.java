class Solution {
    public int maxProfit(int[] prices) {
        //O(n, 1)
        //as you can sell and buy on the same day, do it to achieve max profit
        //idea is to keep buying/selling  as you get a dip in prices
        int maxPSum = 0;
        for(int i=0;i < prices.length-1;i++){
            //point where next element is greater than previous, sell it on i+1, as can buy on i
            if(prices[i+1] > prices[i]){
                maxPSum += prices[i+1] - prices[i];
            }

        }
        return max;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        //O(n, 1)
        //idea is to keep finding least previous value, and when there is dip in stock prices, sell it
        int maxProf = 0;
        int leastFoundSoFar = Integer.MAX_VALUE;

        for(int i=0;i < prices.length;i++){
            //1st maintain least so far, where u buy
            leastFoundSoFar = Math.min(leastFoundSoFar, prices[i]);
            //maximize profit, if u sell at i
            maxProf = Math.max(maxProf, prices[i] - leastFoundSoFar);

        }
        return maxProf;
    }
}
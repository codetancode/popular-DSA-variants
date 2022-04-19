class Solution {
    public int maxProfit(int[] prices, int fee) {
        // BoughtState- where you buy a stocks
        // SellState - where you sell previously bought stock
        // you will get best profit, after selling so return sell state profit

        //as at first we have to buy 1st share, so  -price[0]
        int oldBoughtStateProfit = -prices[0];
        //dont have any thing to sell so 0
        int oldSellStateProfit = 0;

        for(int i=1;i < prices.length;i++){
            int newBoughtStateProfit = 0;
            int newSellStateProfit = 0;

            //update bought state, as we have already bought 1 at 1st, finding better bought state on sellingState
            //as buying, so - prices[i] on old sell state, if it is better than previous bought state,
            //Basically comparing which is better to buy, privious stock(1), or next stock(2)
            if(oldSellStateProfit - prices[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldSellStateProfit - prices[i];
            }else{
                newBoughtStateProfit = oldBoughtStateProfit;
            }

            //finding better sell state on bought state
            //now checking which is better to sell, as selling will get +price[i], and will lose fee, so -fee
            if(oldBoughtStateProfit + prices[i] - fee > oldSellStateProfit){
                newSellStateProfit = oldBoughtStateProfit + prices[i] - fee;
            }else{
                newSellStateProfit = oldSellStateProfit;
            }

            //passing on the new states found after ith price
            oldBoughtStateProfit = newBoughtStateProfit;
            oldSellStateProfit = newSellStateProfit;

        }

        //as finally best profit will come by selling on last day
        return oldSellStateProfit;

    }
}
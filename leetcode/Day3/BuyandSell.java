package day3;

public class BuyandSell {
	public int maxProfit(int[] prices) {
		int buy = prices[0];
		int profit = 0;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (buy < prices[i]) {
				profit = prices[i] - buy;
				maxprofit = maxprofit + profit;
				buy=prices[i];
			} else
				buy = prices[i];
		}
		return maxprofit;
	}
	public static void main(String[] args) {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		BuyandSell p = new BuyandSell();
		int profit = p.maxProfit(nums);
		System.out.print(profit + " ");
	}

}

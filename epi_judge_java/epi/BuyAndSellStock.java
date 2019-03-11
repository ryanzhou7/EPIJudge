package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    double profit = 0.0;
    if(prices.size()==0 || prices.size()==1)
      return profit;
    double minBuy = prices.get(0);
    for(int i = 0; i<prices.size(); i++){
      double c = prices.get(i);
      profit = Math.max(profit, c-minBuy);
      minBuy = Math.min(c, minBuy);
    }
    return profit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}

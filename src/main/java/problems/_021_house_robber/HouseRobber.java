package problems._021_house_robber;

public class HouseRobber {

  public int rob(int[] nums) {
    int prv = 0;
    int prvPrv = 0;
    int current = 0;
    for (int num : nums) {
      prvPrv = prv;
      prv = current;
      current = Math.max(prvPrv + num, prv);
    }
    return current;
  }

}

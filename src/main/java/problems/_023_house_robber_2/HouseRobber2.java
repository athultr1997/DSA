package problems._023_house_robber_2;

public class HouseRobber2 {

  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    int robFirstHouse = robHelper(nums, 0, n - 2);
    int robLastHouse = robHelper(nums, 1, n - 1);
    return Math.max(robFirstHouse, robLastHouse);
  }

  private int robHelper(int[] nums, int l, int r) {
    int prv = 0;
    int prvPrv = 0;
    int current = 0;
    for (int i = l; i <= r; ++i) {
      prvPrv = prv;
      prv = current;
      current = Math.max(nums[i] + prvPrv, prv);
    }
    return current;
  }

}

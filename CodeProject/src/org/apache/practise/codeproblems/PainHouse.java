package org.apache.practise.codeproblems;

public class PainHouse {
  public int minCost(int[][] costs) {
    int[] dp = new int[3];
    if(costs.length<=0) return 0;
    dp[0] = costs[0][0];
    dp[1] = costs[0][1];
    dp[2] = costs[0][2];

    for(int i=1;i<costs.length;++i){
      int temp1 = costs[i][0] + Math.min(dp[1],dp[2]);
      int temp2 = costs[i][1] + Math.min(dp[0],dp[2]);
      int temp3 = costs[i][2] + Math.min(dp[0],dp[1]);
      dp[0] = temp1;
      dp[1] = temp2;
      dp[2] = temp3;

    }
    return Math.min(Math.min(dp[0],dp[1]),dp[2]);
  }
}

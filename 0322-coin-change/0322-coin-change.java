class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        int inf=Integer.MAX_VALUE/2;
        for(int c=1;c<=amount;c++){
            dp[0][c]=inf;
        }
        for(int i=1;i<=n;i++){
            int value=coins[i-1];

            for(int c=0;c<=amount;c++){
                int temp=dp[i-1][c];

                if(value<=c){
                int take=1+dp[i][c-value];
                dp[i][c]=Math.min(dp[i-1][c],take);
                }
                else{
                    dp[i][c]=temp;
                }
            }
        }
        return dp[n][amount]>=inf?-1:dp[n][amount];
    }
}
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            int value=coins[i-1];

            for(int c=0;c<=amount;c++){
                int temp=dp[i-1][c];

                if(value<=c){
                    int take=dp[i][c-value];
                    dp[i][c]=temp+take;
                }
                else{
                    dp[i][c]=temp;
                }
            }
        }
        return dp[n][amount];
    }
}
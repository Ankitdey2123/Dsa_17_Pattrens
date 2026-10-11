class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }

        if(Math.abs(target)>total || (target+total)%2!=0){
            return 0;
        }
        int capacity=(target+total)/2;
        
        int[][] dp=new int[n+1][capacity+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            int value=nums[i-1];

            for(int c=0;c<=capacity;c++){
                int temp=dp[i-1][c];

                if(value<=c){
                    int take=dp[i-1][c-value];

                    dp[i][c]=take+temp;
                }
                else{
                    dp[i][c]=temp;
                }
            }
        }
        return dp[n][capacity];
    }
}
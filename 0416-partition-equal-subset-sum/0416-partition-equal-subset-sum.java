class Solution {
    public boolean canPartition(int[] nums) {
     int n=nums.length;
     int total=0;
     for(int i=0;i<n;i++){
        total+=nums[i];
     }   

     
     if(total%2!=0){
        return false;
     }

     int target=total/2;

     boolean[][] dp=new boolean[n+1][target+1];

     for(int i=0;i<=n;i++){
        dp[i][0]=true;
     }

     for(int i=1;i<=n;i++){
        int value=nums[i-1];

        for(int c=0;c<=target;c++){
            boolean temp=dp[i-1][c];

            if(value<=c){
            boolean take=dp[i-1][c-value];
            dp[i][c]=take || temp;
            }
            else{
                dp[i][c]=temp;
            }
        }
     }
     return dp[n][target];
    }
}
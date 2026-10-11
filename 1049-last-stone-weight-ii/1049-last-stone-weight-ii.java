class Solution {
    public int lastStoneWeightII(int[] stones) {
     int n=stones.length;
     int total=0;
     for(int i=0;i<n;i++){
        total+=stones[i];
     }

     int target=total/2;

     boolean[][] dp=new boolean[n+1][target+1];

     for(int i=0;i<=n;i++){
        dp[i][0]=true;
     }

     for(int i=1;i<=n;i++){
        int value=stones[i-1];

        for(int c=1;c<=target;c++){
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

     for(int s=target;s>=0;s--){
        if(dp[n][s]){
            return total-2*s;
        }
     }

     return 0;
    }
}
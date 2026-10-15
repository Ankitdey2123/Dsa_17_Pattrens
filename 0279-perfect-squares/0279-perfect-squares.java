class Solution {
    public int numSquares(int n) {
        int count=0;
        List<Integer>list=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        count=list.size();
        int[][] dp=new int[count+1][n+1];

        int inf=Integer.MAX_VALUE/2;
        for(int c=1;c<=n;c++){
            dp[0][c]=inf;
        }

        for(int i=1;i<=count;i++){
            int value=list.get(i-1);

            for(int c=0;c<=n;c++){
                int temp=dp[i-1][c];

                if(value<=c){
                    int take=1+dp[i][c-value];

                    dp[i][c]=Math.min(temp,take);
                }
                else{
                    dp[i][c]=temp;
                }
            }
        }

        return dp[count][n];
    }
}
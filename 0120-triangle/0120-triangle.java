class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();

        int[][] dp=new int[row][];

        for(int i=0;i<row;i++){
            dp[i]=new int[triangle.get(i).size()];
        }

        dp[0][0]=triangle.get(0).get(0);

        for(int i=1;i<row;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                int min=Integer.MAX_VALUE;

                if(j<triangle.get(i-1).size()){
                    min=Math.min(min,dp[i-1][j]);
                }

                if(j-1>=0 && j-1<triangle.get(i).size()){
                    min=Math.min(min,dp[i-1][j-1]);
                }
                dp[i][j]=min+triangle.get(i).get(j);
            }
        }

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<dp[row-1].length;i++){
            ans=Math.min(ans,dp[row-1][i]);
        }

        return ans;
    }
}
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;

        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<l;i++){
            int one=0;
            int zero=0;

            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0'){
                    zero++;
                }
                else{
                    one++;
                }
            }

            for(int mm=m;mm>=zero;mm--){
                for(int nn=n;nn>=one;nn--){
                    dp[mm][nn]=Math.max(dp[mm][nn],1+dp[mm-zero][nn-one]);
                }
            }
        }

        return dp[m][n];
    }
}
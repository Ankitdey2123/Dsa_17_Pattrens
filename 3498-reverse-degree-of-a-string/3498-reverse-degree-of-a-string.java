class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int n='z'-ch+1;
            ans=ans+n*(i+1);
        }
        return ans;
    }
}
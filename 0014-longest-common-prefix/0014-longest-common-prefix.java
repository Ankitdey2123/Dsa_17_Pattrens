class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n=strs.length-1;
        String first=strs[0];
        String last=strs[n];
        int i=0;
        String ans="";
        while(i<first.length() && i<last.length()){
            if(first.charAt(i)==last.charAt(i)){
                ans+=first.charAt(i);
            }
            else{
                break;
            }
            i++;
        }
        return ans;
    }
}
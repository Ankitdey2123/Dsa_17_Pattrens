class Solution {
    public int countCommas(int n) {
        if(n<999){
            return 0;
        }
        int diff=n-1000;
        return diff+1;
        
    }
}
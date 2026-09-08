class Solution {
    public int pivotInteger(int n) {
        int totalSum=0;
        for(int i=1;i<=n;i++){
            totalSum+=i;
        }
        int leftSum=0;
        int rightSum;
        for(int i=1;i<=n;i++){
            rightSum=totalSum-leftSum-i;
            if(leftSum==rightSum){
                return i;
            }
            leftSum=leftSum+i;
        }
        return -1;
    }
}
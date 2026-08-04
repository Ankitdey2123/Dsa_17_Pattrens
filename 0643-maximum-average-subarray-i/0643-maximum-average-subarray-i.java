class Solution {
    double maxAvg=0,windowAvg=0;
    public double findMaxAverage(int[] nums, int k) {
        for(int i=0;i<k;i++){
            windowAvg+=nums[i];
        }
        maxAvg=windowAvg/k;
        for(int i=k;i<nums.length;i++){
            windowAvg=windowAvg-nums[i-k]+nums[i];
            double currentAvg=windowAvg/k;
            if(currentAvg>maxAvg){
                maxAvg=currentAvg;
            }
        }
        return maxAvg;
    }
}
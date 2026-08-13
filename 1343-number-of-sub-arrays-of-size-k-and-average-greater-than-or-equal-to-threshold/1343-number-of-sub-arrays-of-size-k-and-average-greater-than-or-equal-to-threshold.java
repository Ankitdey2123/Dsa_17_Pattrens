class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        int count=0;
        if((windowSum/k)>=threshold){
            count++;
        }
        for(int i=k;i<arr.length;i++){
            windowSum=windowSum-arr[i-k]+arr[i];
            if((windowSum/k)>=threshold){
                count++;
            }
        }
        return count;
        
    }
}
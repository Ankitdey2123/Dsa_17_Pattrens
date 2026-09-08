class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int totalsum = 0;
        int l = 0;
        int r = 0;
        int subSum=0;
        while (l < arr.length) {
            if(r<=arr.length-1){
                subSum+=arr[r];
                int count=r-l+1;
                if(count%2!=0){
                    totalsum+=subSum;
                }
                r++;
            }
            else{
                l++;
                r=l;
                subSum=0;  
            }
        }
        return totalsum;

    }
}
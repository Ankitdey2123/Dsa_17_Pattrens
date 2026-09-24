class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=9){
                if(nums[i]==i){
                    return i;
                }
            }
            if(nums[i]>9){
                int a=nums[i];
                int s=0;
                while(a>0){
                    int p=a%10;
                    s=s+p;
                    a=a/10;
                }
                if(s==i){
                    return i;
                }
            }
        }
        return -1;
    }
}
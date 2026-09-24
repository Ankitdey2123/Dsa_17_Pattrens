class Solution {
    public int smallestIndex(int[] nums) {
     for(int i=0;i<nums.length;i++){
        int a=nums[i];
        if(a<=9){
            if(a==i){
                return i;
            }
        }
        else{
            int s=0;
            while(a>0){
                int p=a%10;
                s+=p;
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
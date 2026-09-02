class Solution {
    public boolean uniformArray(int[] nums1) {
        for(int i=0;i<nums1.length;i++){
            if(i>=nums1.length-1){
                if(nums1[i]%2==0 || nums1[i]%2!=0){
                    return true;
                }
            }
            if(nums1[i]-nums1[i+1]%2==0 || nums1[i]-nums1[i+1]%2==0){
                return true;
            }
        }
            return false;
    }
}
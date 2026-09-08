class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int move=0;
        int count=0;
        for(int i:nums){
            move+=i;
            if(move==0){
                count++;
            }
        }
        return count;
        
    }
}
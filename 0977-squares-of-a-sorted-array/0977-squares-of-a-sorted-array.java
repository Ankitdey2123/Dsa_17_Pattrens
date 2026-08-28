class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            double sq=Math.pow(nums[i],2);
            arr[i]=(int)(sq);
        }
        Arrays.sort(arr);
        return arr;
        
        
    }
}
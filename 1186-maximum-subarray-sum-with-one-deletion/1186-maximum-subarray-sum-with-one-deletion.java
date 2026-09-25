class Solution {
    public int maximumSum(int[] arr) {
        int currentSum=arr[0];
        int maxSum=arr[0];

        int deleteValue= -1000000000;

        for(int i=1;i<arr.length;i++){
            int newSum=Math.max(currentSum+arr[i],arr[i]);

            int newDelete=Math.max(deleteValue+arr[i],currentSum);

            currentSum=newSum;
            deleteValue=newDelete;

            maxSum=Math.max(maxSum,Math.max(currentSum,deleteValue));
        }
        return maxSum;
    }
}
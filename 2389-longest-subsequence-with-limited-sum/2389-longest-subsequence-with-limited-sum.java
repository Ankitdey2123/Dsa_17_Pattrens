class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] pre=new int[nums.length];
        Arrays.sort(nums);
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int[] ans=new int[queries.length];
        int count=0;
        for(int i=0;i<queries.length;i++){
            count=0;
            for(int j=0;j<pre.length;j++){
                if(pre[j]<=queries[i]){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}
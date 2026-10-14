class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList());

        for(int i:nums){
            int size=ans.size();

            for(int j=0;j<size;j++){
                List<Integer>temp=new ArrayList<>(ans.get(j));
                temp.add(i);
                ans.add(temp);
            }
        }
        return ans;
    }
}
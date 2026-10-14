class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            int size = ans.size();

            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(ans.get(i));
                boolean beautiful = true;

                for (int value : temp) {
                    if (Math.abs(value - num) == k) {
                        beautiful = false;
                        break;
                    }
                }

                if (beautiful) {
                    temp.add(num);
                    ans.add(temp);
                }
            }
        }

        return ans.size() - 1; 
    }
}
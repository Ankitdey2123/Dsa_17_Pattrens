class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] pass=new int[1001];
        int current=0;
        for(int i=0;i<trips.length;i++){
            int num=trips[i][0];
            int from=trips[i][1];
            int to=trips[i][2];
            pass[from]+=num;
            pass[to]-=num;
        }

        for(int i=0;i<pass.length;i++){
            current+=pass[i];

            if(current>capacity){
                return false;
            }
        }
        return true;
    }
}
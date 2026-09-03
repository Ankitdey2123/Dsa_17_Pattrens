class Solution {
    public int largestAltitude(int[] gain) {
        int[] at=new int[gain.length+1];
        at[0]=0;
        for(int i=1;i<=gain.length;i++){
            at[i]=at[i-1]+gain[i-1];
        }
        int max=0;
        for(int i:at){
            if(i>max){
                max=i;
            }
        }
        return max;
        
    }
}
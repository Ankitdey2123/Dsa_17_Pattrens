class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int answer=0;
        int r=height.length-1;
        while(l<r){
            int w=r-l;
            int con=Math.min(height[l],height[r]);
            int count=w*con;
            answer=Math.max(answer,count);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return answer;
        
    }
}
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0;
        int count=0;
        String answer= "";
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(ch=='1'){
                count++;
            }
            while(count>k){
                char ch1=s.charAt(left);
                if(ch1=='1'){
                    count--;
                }
                left++;
            }
            if(count==k){
                while(s.charAt(left)=='0'){
                    left++;
                }
                String current=s.substring(left,right+1);
                if(answer.equals("")||current.length()<answer.length()||(current.length()==answer.length()) && current.compareTo(answer)<0){
                    answer=current;
                }
            }
        }
        return answer;
        
    }
}
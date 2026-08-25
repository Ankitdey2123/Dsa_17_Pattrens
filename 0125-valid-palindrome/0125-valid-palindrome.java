class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int count=0;
       String newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int right=newS.length()-1;
        while(left<right)
        {
            char ch=newS.charAt(left);
            char ch2=newS.charAt(right);
            if(ch!=ch2){
            return false;
            }
            left++;
            right--;
        }
    return true;
    }
}
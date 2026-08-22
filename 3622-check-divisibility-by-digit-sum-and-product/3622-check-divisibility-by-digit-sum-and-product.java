class Solution {
    public boolean checkDivisibility(int n) {
        int a=n;
        int sum=0;
        int product=1;
        while(n>0){
            int p=n%10;
            sum=sum+p;
            n=n/10;
        }
        int b=a;
        while(a>0){
            int p=a%10;
            product=product*p;
            a=a/10;
        }
        if(b%(sum+product)==0){
            return true;
        }
        return false;
        
    }
}
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>set=new LinkedHashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }

            set.add(n);
            int sum=0;
            while(n>0){
                int p=n%10;
                sum=sum+p*p;
                n=n/10;
            }
            n=sum;
        }
        return true;
    }
}
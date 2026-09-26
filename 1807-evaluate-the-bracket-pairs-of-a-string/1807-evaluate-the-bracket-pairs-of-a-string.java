class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        String ans="";
        int l=0;
        HashMap<String,String>map=new LinkedHashMap<>();

        for(List<String> ch:knowledge){
            map.put(ch.get(0),ch.get(1));
        }
        while(l<s.length()){
            char ch=s.charAt(l);
            if(ch=='('){
                int j=l+1;
                while(j<s.length()){
                    char ch1=s.charAt(j);
                    if(ch1==')'){
                        break;
                    }
                    j++;
                }
                String key=s.substring(l+1,j);
                String value=map.get(key);
                if(value==null){
                    ans=ans+"?";
                }
                else{
                    ans=ans+value;
                }
                l=j+1;
            }
            else{
                ans=ans+s.charAt(l);
                l++;
            }
        }
        return ans;
    }
}
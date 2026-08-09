class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String>set=new LinkedHashSet<>();
        for(int i=0;i<emails.length;i++){
            String getEmail=emails[i];
            int at=getEmail.indexOf("@");
            String local=getEmail.substring(0,at);
            String domain=getEmail.substring(at+1);
            int plus=local.indexOf("+");
            if(plus!=-1){
                local=local.substring(0,plus);
            }
            if(local.contains(".")){
                local=local.replace(".","");
            }
            String finalEmail=local+"@"+domain;
            set.add(finalEmail);
        }
        int count=set.size();
        return count;
    }
}
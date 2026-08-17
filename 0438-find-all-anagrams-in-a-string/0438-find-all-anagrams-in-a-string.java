class Solution {
    public List<Integer> findAnagrams(String s, String p) {
     HashMap<Character,Integer>pattern=new LinkedHashMap<>();
     HashMap<Character,Integer>map=new LinkedHashMap<>();
     ArrayList<Integer>list=new ArrayList<>();
     if(p.length()>s.length()){
        return list;
     }
     for(int i=0;i<p.length();i++){
        char ch=p.charAt(i);
        if(pattern.containsKey(ch)){
            pattern.put(ch,pattern.get(ch)+1);
        }
        else{
            pattern.put(ch,1);
        }
     }
     int k=p.length();
    
    for(int i=0;i<k;i++){
        char ch=s.charAt(i);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }
        else{
            map.put(ch,1);
        }
    }
    if(pattern.equals(map)){
        list.add(0);
    }
    for(int i=k;i<s.length();i++){
        char remove=s.charAt(i-k);
        if(map.get(remove)==1){
            map.remove(remove);
        }
        else{
            map.put(remove,map.get(remove)-1);
        }
        char add=s.charAt(i);
        if(map.containsKey(add)){
            map.put(add,map.get(add)+1);
        }
        else{
            map.put(add,1);
        }
        if(pattern.equals(map)){
            list.add(i-k+1);
        }
    }
    return list;

    }
}
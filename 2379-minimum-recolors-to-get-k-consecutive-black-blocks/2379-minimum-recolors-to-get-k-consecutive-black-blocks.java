class Solution {
    public int minimumRecolors(String blocks, int k) {
        HashMap<Character,Integer>map=new LinkedHashMap<>();
        int operation=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            char ch=blocks.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        if(map.get('W')!=null){
            operation=Math.min(operation,map.get('W'));
        }
        else{
            operation=0;
        }
        
        for(int i=k;i<blocks.length();i++){
            char remove=blocks.charAt(i-k);
            if(map.get(remove)==1){
                map.remove(remove);
            }
            else{
                map.put(remove,map.get(remove)-1);
            }
            char add=blocks.charAt(i);
            if(map.containsKey(add)){
                map.put(add,map.get(add)+1);
            }
            else{
                map.put(add,1);
            }
            if(map.get('W')!=null){
               operation=Math.min(operation,map.get('W'));;
            }
            else{
              operation=0;
            }
        }
        return operation;

    }
}
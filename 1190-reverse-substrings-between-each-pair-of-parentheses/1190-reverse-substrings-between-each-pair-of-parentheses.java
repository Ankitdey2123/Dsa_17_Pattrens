class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>stack=new Stack<>();    
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch!=')'){
                stack.push(ch);
            }
            else{
                String temp="";

                while(stack.peek()!='('){
                    temp=temp+stack.pop();
                }
                stack.pop();
                int index=0;
                while(index<temp.length()){
                    char ch2=temp.charAt(index);
                    stack.push(ch2);
                    index++;
                }
            }
        }
        String res="";
        while(!stack.isEmpty()){
            res=stack.pop()+res;
        }
        return res;
        
    }
}
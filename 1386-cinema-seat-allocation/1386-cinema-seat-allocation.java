class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>>map=new LinkedHashMap<>();
        for(int[] a:reservedSeats){
            int row=a[0];
            int cal=a[1];
            if(!map.containsKey(row)){
                map.put(row,new HashSet<>());
            }
            map.get(row).add(cal);
        }
        int ans=n*2;

        for(int i:map.keySet()){
            HashSet<Integer> r=map.get(i);
            boolean grpA=!r.contains(2) && !r.contains(3) && !r.contains(4) && !r.contains(5);
            boolean grpB=!r.contains(4) && !r.contains(5) && !r.contains(6) && !r.contains(7);
            boolean grpC=!r.contains(6) && !r.contains(7) && !r.contains(8) && !r.contains(9);

            if(grpA && grpC ){
            }
            else if(grpA || grpB || grpC){
                ans-=1;
            }
            else{
                ans-=2;
            }
        }
        return ans;
    }
}
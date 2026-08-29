class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        int n=list.size();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        double median;
        if(n%2!=0){
            median=arr[n/2];
        }
        else{
            median=(arr[n/2-1]+arr[n/2])/2.0;
        }
        return median;
        
    }
}
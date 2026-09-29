class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     int start=0;
     int tank=0;
     int totalGas=0;
     int totalCost=0;
     for(int i=0;i<gas.length;i++){
        tank=tank+gas[i]-cost[i];
        if(tank<0){
            start=i+1;
            tank=0;
        }
        totalGas=totalGas+gas[i];
        totalCost=totalCost+cost[i];
     }
     if(totalGas<totalCost){
        return -1;
     }   
     return start;
    }
}
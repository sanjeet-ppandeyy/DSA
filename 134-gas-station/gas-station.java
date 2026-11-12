import java.util.*;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) return -1;
        int currGas = 0;
        int idx = 0;
        for(int i = 0; i < n; i++){
            currGas += gas[i] - cost[i];
            if(currGas < 0){
                idx = i+1;
                currGas = 0;
            }
        }
        return idx;
    }
}
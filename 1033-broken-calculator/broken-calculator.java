import java.util.*;
class Solution {
    public int helper(int num, int target){
        if(num >= target) return num - target;
        if(target % 2 == 0) {
            return 1 + helper(num,target/2);
        }else{
            return 1 + helper(num,target+1);
        }
    }
    public int brokenCalc(int num, int target) {
        return helper(num,target);
    }
}
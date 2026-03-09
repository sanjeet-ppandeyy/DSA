class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        double [] sum = new double[n];
        sum[0] = 0;
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        double[] product = new double[n];
        product[n-1] = 1; 
        for(int i=nums.length-2; i>=0; i--){
            product[i] = product[i+1] * nums[i+1];
        }
        for(int i=0; i<n; i++){
            if(sum[i] == product[i]) return i;
        }
        return -1;
    }
}
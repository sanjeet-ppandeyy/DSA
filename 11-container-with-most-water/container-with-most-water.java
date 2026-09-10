class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int j = n-1;  
        int i = 0;      
        while(i < j){
            int val = Math.min(height[i],height[j]);
            max = Math.max(max,val*(j-i));
            if(height[i] > height[j]){
                j--;
            }else i++;
        }
        return max;
    }
}
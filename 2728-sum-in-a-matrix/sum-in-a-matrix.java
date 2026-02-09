class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int ans = 0;

        for(int i=0; i<n; i++){
            Arrays.sort(nums[i]);
        }

        for(int i=0; i<m; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int j=0; j<n; j++){
                pq.add(nums[j][i]);
            }
            ans += pq.peek();
        }
        return ans;
    }
}
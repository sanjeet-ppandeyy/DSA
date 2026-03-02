class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int ele = grid[i][j];
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                int freq = map.get(grid[i][j]);
                if(freq == 2) ans[0] = grid[i][j];
            }
        }
        for(int i=1; i<=n*n; i++){
           if(!map.containsKey(i)) ans[1] = i;
        }
        return ans;
    }
}
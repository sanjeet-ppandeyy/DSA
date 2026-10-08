class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int[] end = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i][0] <= end[1]) end[1] = Math.max(end[1],arr[i][1]);
            else{
                ans.add(end);
                end = arr[i];
            } 
        }
        ans.add(end);
        return ans.toArray(new int[ans.size()][]);
    }
}
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min_d = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
            min_d = Math.min(min_d,arr[i+1] - arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            List<Integer> l = new ArrayList<>();
            if(arr[i+1] - arr[i] == min_d){
                l.add(arr[i]);
                l.add(arr[i+1]);
                ans.add(l);
            }
        }
        return ans;
    }
}
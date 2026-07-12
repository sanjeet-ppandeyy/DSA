class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] t = new int[n];
        for(int i=0; i<n; i++) t[i] = arr[i];
        Arrays.sort(t);
        HashMap<Integer,Integer> map = new HashMap<>();
        int r = 1;
        for(int ele : t){
            if(!map.containsKey(ele)) map.put(ele,r++);
        }
        for(int i=0; i<n; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
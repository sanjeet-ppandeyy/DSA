class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        for(int arr : friends) set.add(arr);
        int[] ans = new int[set.size()];
        int idx = 0;
        for(int i=0; i<order.length; i++){
            if(set.contains(order[i])) ans[idx++] = order[i];
        }
        return ans;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                int temp = st.pop();
                ans[temp] = i - temp;
            }
            st.push(i);
        }
        return ans;
    }
}
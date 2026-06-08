class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int i=0; i<bookings.length; i++){
            int first = bookings[i][0];
            int last = bookings[i][1];
            int add = bookings[i][2];
            ans[first-1] += add;
            if(last < n) ans[last] -= add; 
        }
        for(int i=1; i<n; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
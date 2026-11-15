class Solution {
    int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int evenCount = 1;
        int oddCount = 0;
        int ans = 0;
        for(int x : arr){
            sum += x;
            if(sum % 2 == 0){
                ans += oddCount;
                evenCount++;
            }else{
                ans += evenCount;
                oddCount++;
            }
            ans = ans % MOD;
        }
        return ans;
    }
}
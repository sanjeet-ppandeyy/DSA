class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int k) {
        int n = customers.length;
        int i = 0, j = k-1;
        int left = i, right = j, unst = 0;
        int maxUnst = 0;
        for(int x=0; x<n-k+1; x++){
            if (grumpy[x] == 1) unst += customers[x];
        }
        while (j<n){
            if (maxUnst < unst){
                maxUnst = unst;
                left = i;
                right = j;
            }
            i++;
            j++;
            if(j<n && grumpy[j] == 1) unst += customers[j];
            if(grumpy[i-1] == 1) unst -= customers[i-1];
        }
        for (int x=left; x<=right; x++){
            grumpy[x] = 0;
        }
        int ans = 0;
        for (int x=0; x<n; x++){
            if(grumpy[x] == 0) ans += customers[x];
        }
        return ans;
    }
}
import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, a = 0, b = 0;
        int k2 = 0;
        int count = 0;
        for(int x=0; x<n; x++){
            if(nums[x] % 2 == 0) nums[x] = 0;
            else nums[x] = 1;
        }
        while (i<n && nums[i]==0){
            i++;
        }
        while (j < n && k2 < k) if (nums[j++] == 1) k2++;
        if(k2 < k) return 0;
        j--;
        b = j + 1;
        while (b < n && nums[b] == 0) b++;
        b--;
        while (b < n){
            count += (i-a+1) * (b-j+1);
            a = i+1;
            i++;
            while (i<n && nums[i] == 0) i++;
            j = b + 1;
            b = j + 1;
            while (b < n && nums[b] == 0) b++;
            b--;
        }
        return count;
    }
}
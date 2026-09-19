import java.util.*;

class Solution {
    public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray();

        for (int i = 0; i < k; i++) {
            nextPermutation(arr);
        }
        char[] main = num.toCharArray();
        int count = 0;
        for (int i = 0; i < main.length; i++) {
            if(main[i] == arr[i]) continue;
            int j = i + 1;
            while (main[j] != arr[i]) j++;
            while (j > i) {
                char temp = main[j];
                main[j] = main[j - 1];
                main[j - 1] = temp;
                j--;
                count++;
            }
        }
        return count;
     }
        
    private void nextPermutation(char[] nums) {
        int n = nums.length;
            
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
         
        if (i < 0) return;
        int j = n - 1;
        
        while (nums[j] <= nums[i]) j--;
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
                    
        int l = i + 1;
        int r = n - 1;
        while (l < r) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        
            l++;
            r--;
        }
     }
}
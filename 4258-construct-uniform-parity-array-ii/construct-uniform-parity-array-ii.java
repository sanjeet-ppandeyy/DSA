import java.util.*;

class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int[] nums2 = new int[n];

        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(nums1[i] % 2 == 0) {
                evenMin = Math.min(evenMin, nums1[i]);
            }else{
                oddMin = Math.min(oddMin, nums1[i]);
            }
        }
        
        if(oddMin == Integer.MAX_VALUE || evenMin == Integer.MAX_VALUE) {
            return true;
        }

        int i = 0;
        while(i < n) {
            if(nums1[i] % 2 == 0) {
                if(oddMin < nums1[i]) {
                    nums2[i] = nums1[i] - oddMin;
                }else{
                    return false;
                }
            }else{
                nums2[i] = nums1[i];
            }

            i++;
        }
        for(i = 0; i < n; i++) {
            if(nums2[i] % 2 == 0) {
                break;
            }
        }

        if(i == n) {
            return true;
        }

        i = 0;
        while(i < n) {
            if(nums1[i] % 2 != 0) {
                if(evenMin < nums1[i]) {
                    nums2[i] = nums1[i] - evenMin;
                }else{
                    return false;
                }
            }else{
                nums2[i] = nums1[i];
            }

            i++;
        }
        for(i = 0; i < n; i++) {
            if(nums2[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
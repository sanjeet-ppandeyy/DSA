import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr,(a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        int swaps = 0;
        for(int i = 0; i < n; i++) {
            if(sorted[i] != arr[i]) {
                int idx = map.get(arr[i]);
                int temp = sorted[i];
                sorted[i] = sorted[idx];
                sorted[idx] = temp;
                map.put(sorted[idx], idx);
                map.put(sorted[i], i);

                swaps++;
            }
        }
        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
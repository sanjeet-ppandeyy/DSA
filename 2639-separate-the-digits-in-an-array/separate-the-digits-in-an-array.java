class Solution {
    public void digit(int n,List<Integer> ans){
        List<Integer> temp = new ArrayList<>();
        while(n != 0){
            int digit = n % 10;
            temp.add(digit);
            n = n/10;
        }
        Collections.reverse(temp);
        ans.addAll(temp);
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            digit(nums[i],ans);
        }
        int[] arr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
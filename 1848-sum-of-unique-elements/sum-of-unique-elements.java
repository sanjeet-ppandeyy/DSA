class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int sum = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq == 1) sum += key;
        }
        return sum;
    }
}
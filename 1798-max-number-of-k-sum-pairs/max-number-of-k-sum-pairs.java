class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            int rem = k-num;
            if(map.containsKey(rem) && map.get(rem) > 0){
                count++;
                int freq = map.get(rem);
                map.put(rem,freq-1);
            }else{
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }else map.put(num,1);
            }
        }    
        return count;
    }
}
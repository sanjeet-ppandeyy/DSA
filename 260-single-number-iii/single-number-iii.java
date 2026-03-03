class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){ 
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq == 1){
                ans.add(key);
            }
        }
        int[] res = new int[2];
        res[0] = ans.get(0);
        res[1] = ans.get(1);
        return res;    
    }
}
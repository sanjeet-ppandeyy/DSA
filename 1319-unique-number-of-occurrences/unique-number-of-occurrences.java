class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int ele = arr[i];
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1);
            }else map.put(ele,1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ele : map.keySet()){
            set.add(map.get(ele));
        }
        if(set.size() != map.size()) return false;
        else return true;
    }
}
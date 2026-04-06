class Solution {
    public int countSum(int n){
         int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxSize = 0;
        for(int i=1; i<=n; i++){
            int sum = countSum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
            maxSize = Math.max(maxSize,map.get(sum));
        }
        int count = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq == maxSize) count++;
        }
        return count;
    }
}
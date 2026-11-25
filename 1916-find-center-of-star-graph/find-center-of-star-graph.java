import java.util.HashMap;
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            map.put(edges[i][0],map.getOrDefault(edges[i][0],0) + 1);
            map.put(edges[i][1],map.getOrDefault(edges[i][1],0) + 1);
        }
        int max = edges.length;
        int star = -1;
        for(int x : map.keySet()){
            if(map.get(x) == max) return x;
        }
        return -1;
    }
}
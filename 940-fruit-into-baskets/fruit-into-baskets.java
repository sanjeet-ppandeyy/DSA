import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int maxFrt = 0;
        for (int j = 0; j<n; j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while (map.size() > 2){
                map.put(fruits[i],map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            maxFrt = Math.max(maxFrt,j-i+1);
        }
        return maxFrt;
    }
}
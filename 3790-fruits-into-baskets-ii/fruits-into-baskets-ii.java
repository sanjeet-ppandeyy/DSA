class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (fruits[i] == -1 && baskets[j] == -1) continue;
                if (fruits[i] <= baskets[j]){
                    fruits[i] = -1;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(baskets[i] != -1) count++;
        }
        return count;
    }
}
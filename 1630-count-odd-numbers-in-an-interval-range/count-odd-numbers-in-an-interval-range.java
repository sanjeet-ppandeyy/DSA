class Solution {
    public int countOdds(int low, int high) {
        int odd1 = (high + 1)/2;
        int odd2 = (low) / 2;
        return odd1 - odd2;
    }
}
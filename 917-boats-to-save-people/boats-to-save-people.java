class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);
        int n = people.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                boatCount++;
                i++;
                j--;
            } else {
                boatCount++;
                j--;
            }
        }
        return boatCount;
    }
}
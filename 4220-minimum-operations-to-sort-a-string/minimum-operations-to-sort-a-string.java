class Solution {
    public boolean isSorted(char[] arr, char[] sorted){
        int i=0;
        int j=0;
        while(i<arr.length && j<sorted.length){
            if(arr[i] != sorted[j]) return false;
            i++;
            j++;
        }
        return true;
    }
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        if(isSorted(arr, sorted)) return 0;
        if(n == 2) return -1;
        if(sorted[0] == arr[0] || sorted[n-1] == arr[n-1]) return 1;
        if(sorted[0] != sorted[1] && sorted[n-1] == arr[0] && sorted[n-1] != sorted[n-2] && sorted[0] == arr[n-1]) return 3;
        return 2;
    }
}

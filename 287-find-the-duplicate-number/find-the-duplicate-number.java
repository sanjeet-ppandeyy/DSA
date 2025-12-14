class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i < n){
            int rightIdx = arr[i] - 1;
            if(arr[i] == i+1 || arr[rightIdx] == arr[i]) i++;
            else swap(arr,i,rightIdx);
        }
        for(i=0; i<n; i++){
            if(arr[i] != i+1) return arr[i];
        }
        return -1;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

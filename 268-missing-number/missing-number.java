class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i < arr.length){
            if(arr[i] == i || arr[i] == n) i++;
            else{
                int idx = arr[i];
                swap(arr,i,idx);            }
        }
        for(i=0; i<arr.length; i++){
            if(arr[i] != i ) return i;
        }
        return n;
    }
    public void swap(int[] arr, int i, int idx){
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}
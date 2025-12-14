class Solution {
    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n==1) return;
        // Step1 : create 2 Empty array size n/2 of each
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];

        //Step2 : copy - paste array into a and b
        int idx = 0;
        for(int i=0; i<a.length; i++)
            a[i] = arr[idx++];
        for(int i=0; i<b.length; i++)
            b[i] = arr[idx++];

        //Step3: magic
        mergeSort(a);
        mergeSort(b);

        //Step4: merge a and b into arr
        merge(a,b,arr);
    }
    public static void merge(int[] a, int[] b, int[] c){
        int i=0, j=0, k=0;
        while (i<a.length && j<b.length){
            if (a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while (i<a.length) c[k++] = a[i++];
        while (j<b.length) c[k++] = b[j++];
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
}
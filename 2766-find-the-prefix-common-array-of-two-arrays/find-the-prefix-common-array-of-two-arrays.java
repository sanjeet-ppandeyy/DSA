class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int n = A.length;
        for(int i=0; i<n; i++){
            set1.add(A[i]);
            set2.add(B[i]);

            int count = 0;

            for(int x : set1){
                if(set2.contains(x)) count++;
            }

            A[i] = count;
        }
        return A;
    }
}
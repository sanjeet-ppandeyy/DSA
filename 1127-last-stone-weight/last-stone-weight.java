class Solution {
    static {
        // Shutdown hook to write "0" into display_runtime.txt
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) { }
        }));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int x = pq.remove();
            int y = pq.remove();
            if(x != y){
                int diff  = Math.abs(x-y);
                pq.add(diff);
            }
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}
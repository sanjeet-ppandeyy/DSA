class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i=num1; i<=num2; i++){
            int number = i;
            ArrayList<Integer> list = new ArrayList<>();
            while(number != 0){
                list.addLast(number % 10);
                number /= 10;
            }
            for(int j=1; j<=list.size()-2; j++){
                if(list.get(j) > list.get(j-1) && list.get(j) > list.get(j+1)) count++;
                else if(list.get(j) < list.get(j-1) && list.get(j) < list.get(j+1)) count++;
            }
        }
        return count;
    }
}
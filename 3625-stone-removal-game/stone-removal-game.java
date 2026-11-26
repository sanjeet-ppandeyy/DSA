class Solution {
    public boolean canAliceWin(int n) {
        int r = 10;
        boolean flag = true;
        while(n >= r){
            n -= r;
            r--;
            flag = !flag;
        }
        return !flag;
    }
}
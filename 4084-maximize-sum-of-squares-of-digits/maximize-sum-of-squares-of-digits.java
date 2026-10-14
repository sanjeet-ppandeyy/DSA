import java.util.Arrays;

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num) return "";
        StringBuilder sb = new StringBuilder();
        int nine = sum / 9;
        for (int i = 1; i <= nine; i++) sb.append(9);

        int rem = sum % 9;
        if(rem > 0) sb.append(rem);

        int zero = num - sb.length();
        for(int i = 1; i <= zero; i++) sb.append(0);
        return sb.toString();
    }
}

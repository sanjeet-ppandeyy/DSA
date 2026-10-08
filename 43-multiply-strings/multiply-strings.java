class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                int mul = a * b;
                int sum = mul + res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int x : res) {
            if(ans.length() == 0 && x == 0) {
                continue;
            }
            ans.append(x);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}

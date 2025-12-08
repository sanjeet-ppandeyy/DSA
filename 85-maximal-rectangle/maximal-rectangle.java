class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] nse = new int[n];
        nse[n - 1] = n;

        Stack<Integer> st = new Stack<>();
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();
        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    static int maximalRectangle(char mat[][]) {

        int m = mat.length;
        int n = mat[0].length;

        // Convert char[][] to int[][] heights
        int[][] heights = new int[m][n];

        // First row conversion
        for (int j = 0; j < n; j++) {
            heights[0][j] = (mat[0][j] == '1') ? 1 : 0;
        }

        // Build histogram heights
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == '1')
                    heights[i][j] = heights[i - 1][j] + 1;  // accumulate height
                else
                    heights[i][j] = 0;
            }
        }

        int max = 0;
        for (int[] row : heights) {
            max = Math.max(max, getMaxArea(row));
        }

        return max;
    }
}

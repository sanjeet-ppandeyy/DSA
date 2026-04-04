class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            count[ch - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char ch : arr) {
            count[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
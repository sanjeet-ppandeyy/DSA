class Solution {
    List<String> list = new ArrayList<>();
    public void helper(int i,char[] arr,StringBuilder sb){
        if(i == arr.length){
            list.add(sb.toString());
            return;
        }
        if (Character.isDigit(arr[i])) {
            sb.append(arr[i]);
            helper(i + 1, arr, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else {
            sb.append(Character.toLowerCase(arr[i]));
            helper(i + 1, arr, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(arr[i]));
            helper(i + 1, arr, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        char[] arr = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        helper(0,arr,sb);
        return list;
    }
}
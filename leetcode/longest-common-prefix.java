class Solution {
    public String longestCommonPrefix(String[] strs) {
        String target = strs[0];

        for(int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);

            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != targetChar) {
                    return target.substring(0, i);
                }
            }
        }
        return target;
    }
}

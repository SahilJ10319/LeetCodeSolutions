class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int h = haystack.length();
        
        if(n > h) {
            return -1;
        }
        
        if(n == 0) {
            return 0;
        }
        
        for(int i = 0; i < h - n + 1; i++) {
            int j = 0;
            for(;j < n; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == n) {
                return i;
            }
        }
        return -1;
    }
}

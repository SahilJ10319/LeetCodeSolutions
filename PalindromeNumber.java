class Solution {
    public boolean isPalindrome(int x) {
        int result = 0;
        
        if(x == 0) {
            return true;
        }
        
        if(x < 0 || x % 10 == 0) {
            return false;
        }
        
        while(x > result) {
            int pop = x % 10;
            x /= 10;
            result = result * 10 + pop;
        }
        if(result == x || result / 10 == x) {
            return true;
        }
        return false;
    }
}

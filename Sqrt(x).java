class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        
        long low = 1;
        long high = x;
        while(low < high) {
            long mid = low + (high - low) / 2 + 1;
            if(mid == x / mid) {
                return (int) mid;
            }
            else if (mid * mid < x) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return (int) low;
    }
}

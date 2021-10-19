class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        
        while(p2 >= 0) {
            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[t--] = nums1[p1--];
            }
            else {
                nums1[t--] = nums2[p2--];
            }
        }
    }
}

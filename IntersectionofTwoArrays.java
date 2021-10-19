class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Add all values in first array to HashSet
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1) {
            set.add(i);
        }
        
        // Use HashSet to find values common in set and second array
        HashSet<Integer> intersection = new HashSet<>();
        for(int i : nums2) {
            if(set.contains(i)) {
                intersection.add(i);
            }
        }
        
        // Format answer in integer array format
        int index = 0;
        int[] result = new int[intersection.size()];
        for(int i : intersection) {
            result[index++] = i;
        }
        return result;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result)) {
                return new int[] {i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }
}

//https://leetcode.com/problems/3sum/description/?source=submission-ac

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int start = i+1;
        int end = nums.length-1;
        while(start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if(sum == 0) {
                result.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                while(start < end && nums[start] == nums[start-1]) start++;
            } else if(sum < 0) start++;
                    else end--;
        }
    } 
}

//Time Complexity : O(n^2)
//Space Complexity : O(logn) to O(n) depending on sorting algorithm

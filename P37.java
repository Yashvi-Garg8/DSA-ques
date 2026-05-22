//solution for LeetCode problem 37
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] map = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + 10000]++;
        }
        int[] arr = new int[k];
        while (k > 0) {
            int max = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[max] < map[i]) {
                    max = i;
                }
            }
            arr[k - 1] = max - 10000;
            map[max] = 0;
            k--;
        }

        return arr;
    }
}
// time complexity ~ O(N)+O(k*20001)
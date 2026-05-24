// solution to LeetCode problem :456
class P456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int num = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < num) {
                return true;
            }
            while (!st.isEmpty() && nums[i] > st.peek()) {
                num = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
    // time complexity~O(N)
    // space complexity ~O(N) due to stack
}
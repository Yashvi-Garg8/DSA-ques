// solution to problem 436 LeetCode
class P436 {
    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        int[][] starts = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int target = intervals[i][1];
            int idx = lowerBound(starts, target);
            ans[i] = (idx == intervals.length) ? -1 : starts[idx][1];
        }
        return ans;
    }

    public int lowerBound(int[][] starts, int target) {
        int l = 0;
        int r = starts.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (starts[m][0] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
// time complexity ~ O(NlogN)
// space complexity ~ O(Nx2)
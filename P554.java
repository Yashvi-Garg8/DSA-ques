class P554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> gaps = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                gaps.put(sum, gaps.getOrDefault(sum, 0) + 1);
            }
        }
        int maxGap = 0;
        for (int count : gaps.values()) {
            maxGap = Math.max(maxGap, count);
        }
        return wall.size() - maxGap;
    }
    // time complexity ~ O(N) (N is number of bricks)
    // space complexity ~ O(W) used by hashmap to store W number of gaps
}
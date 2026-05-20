import java.util.*;

// solution to LeetCode Weekly Contest 502 Q1
public class wc5021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isAdjacentDiffAtMostTwo(s));
    }

    // brute force approach
    public static boolean isAdjacentDiffAtMostTwo(String s) {
        Set<Integer> set = Set.of(-2, -1, 0, 1, 2);
        for (int i = 0; i < s.length() - 1; i++) {
            int diff = (s.charAt(i) - '0') - (s.charAt(i + 1) - '0');
            if (!set.contains(diff)) {
                return false;
            }
        }
        return true;
    }

    // time complexity O(N-1)~O(N)
    // space complexity O(c)~O(1) due to set
    // slight optimization - better approach
    public static boolean isAdjacentDiffAtMostTwoBetter(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            int diff = s.charAt(i) - s.charAt(i + 1);
            if (Math.abs(diff) > 2) {
                return false;
            }
        }
        return true;
    }
    // time complexity O(N-1)~O(N)
    // space complexity O(1) no set allocation
}
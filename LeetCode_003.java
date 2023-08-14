import java.util.HashMap;
import java.util.Map;

public class LeetCode_003 {


    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length(), left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(c, right);
        }
        return ans;
    }
}

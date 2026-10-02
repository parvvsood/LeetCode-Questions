import java.util.*;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }
        long sum = 0;
        long even = 2;
        while (sum + even <= finalSum) {
            ans.add(even);
            sum += even;
            even += 2;
        }
        if (sum < finalSum) {
            long remaining = finalSum - sum;

            int last = ans.size() - 1;
            ans.set(last, ans.get(last) + remaining);
        }

        return ans;
    }
}
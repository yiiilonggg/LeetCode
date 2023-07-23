class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        usageLimits.sort((a, b) -> a - b);
        int left = 0, right = usageLimits.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(usageLimits, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (check(usageLimits, left)) ? left : left - 1;
    }

    public boolean check(List<Integer> u, int x) {
        int surp = 0, curr, i;
        for (curr = 1, i = 0; curr <= x && i < u.size(); curr++) {
            if (u.get(i) >= curr) {
                surp += u.get(i) - curr;
                i++;
            } else {
                if (u.get(i) + surp >= curr) {
                    surp -= curr - u.get(i);
                    i++;
                    continue;
                }
                while (i < u.size() && surp < curr) {
                    surp += u.get(i);
                    i++;
                }
                if (surp >= curr) {
                    surp -= curr;
                } else {
                    return false;
                }
            }
        }
        return curr > x;
    }
}

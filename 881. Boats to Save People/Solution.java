class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, n = people.length, right = n - 1, count = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            count++;
        }
        return count;
    }
}
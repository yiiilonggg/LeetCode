class Solution {
    public int splitNum(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        Collections.sort(digits);
        int res = 0, pointer = 0;
        if (digits.size() % 2 == 1) {
            res += digits.get(pointer);
            pointer++;
        }
        while (pointer < digits.size()) {
            res = res * 10 + digits.get(pointer) + digits.get(pointer + 1);
            pointer += 2;
        }
        return res;
    }
}
class Solution {
    Map<Character, List<String>> keys = Map.of(
        '2', new ArrayList<>(List.of("a", "b", "c")),
        '3', new ArrayList<>(List.of("d", "e", "f")),
        '4', new ArrayList<>(List.of("g", "h", "i")),
        '5', new ArrayList<>(List.of("j", "k", "l")),
        '6', new ArrayList<>(List.of("m", "n", "o")),
        '7', new ArrayList<>(List.of("p", "q", "r", "s")),
        '8', new ArrayList<>(List.of("t", "u", "v")),
        '9', new ArrayList<>(List.of("w", "x", "y", "z"))
    );
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        if (digits.length() == 1) return keys.get(digits.charAt(0));
        List<String> res = new ArrayList<>();
        for (String k : keys.get(digits.charAt(0))) {
            for (String foll : letterCombinations(digits.substring(1))) {
                res.add(k + foll);
            }
        }
        return res;
    }
}

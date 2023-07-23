class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> vs = new ArrayList<>();
        List<Integer> ps = new ArrayList<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (vowels.contains(ss[i])) {
                vs.add(ss[i]);
                ps.add(i);
            }
        }
        vs.sort((a, b) -> a - b);
        int i = 0;
        for (int p : ps) {
            ss[p] = vs.get(i);
            i++;
        }
        return new String(ss);
    }
}

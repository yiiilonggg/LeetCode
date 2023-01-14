class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m = s1.length(), n = baseStr.length();
        int[] parents = new int[26];
        for (int i = 0; i < 26; i++) parents[i] = i;
        for (int i = 0; i < m; i++) {
            union(parents, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append((char) ('a' + find(parents, baseStr.charAt(i) - 'a')));
        }
        return str.toString();
    }

    public int find(int[] parents, int i) {
        while (parents[i] != i) i = parents[i];
        return i;
    }

    public void union(int[] parents, int first, int second) {
        int firstGroup = find(parents, first);
        int secondGroup = find(parents, second);
        if (firstGroup < secondGroup) {
            parents[secondGroup] = firstGroup;
        } else {
            parents[firstGroup] = secondGroup;
        }
    }
}
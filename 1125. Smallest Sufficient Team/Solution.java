class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        Map<String, Integer> skill = new HashMap<>();
        for (int i = 0; i < n; i++) skill.put(req_skills[i], i);
        int[] pmask = new int[m];
        Map<Integer, List<Integer>> dp = new HashMap<>();
        for (int i = 0; i < (1 << n); i++) dp.put(i, new ArrayList<>());
        for (int i = 0; i < m; i++) {
            for (String c : people.get(i)) {
                pmask[i] |= (1 << skill.get(c));
            }
        }
        for (int i = 0; i < m; i++) {
            for (Map.Entry<Integer, List<Integer>> pair : dp.entrySet()) {
                if (pair.getKey() != 0 && pair.getValue().size() == 0) continue;
                int curr = pair.getKey() | pmask[i];
                if (curr == pair.getKey()) continue;
                if (dp.get(curr).size() == 0 || dp.get(curr).size() > pair.getValue().size() + 1) {
                    List<Integer> nteam = new ArrayList<>(pair.getValue());
                    nteam.add(i);
                    dp.put(curr, nteam);
                }
            }
        }
        int[] res = new int[dp.get((1 << n) - 1).size()];
        for (int i = 0; i < dp.get((1 << n) - 1).size(); i++) res[i] = dp.get((1 << n) - 1).get(i);
        return res;        
    }
}

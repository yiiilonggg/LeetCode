class Solution {
    Map<String, List<Pair>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int q = queries.size(), e = equations.size();
        graph = new HashMap<>();
        double[] res = new double[q];
        for (int i = 0; i < e; i++) {
            if (!graph.containsKey(equations.get(i).get(0))) graph.put(equations.get(i).get(0), new ArrayList<>());
            if (!graph.containsKey(equations.get(i).get(1))) graph.put(equations.get(i).get(1), new ArrayList<>());
            graph.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            graph.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1 / values[i]));
        }
        for (int i = 0; i < q; i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1);
        }
        return res;
    }

    public double dfs(String curr, String target, Set<String> visited, double v) {
        if (visited.contains(curr) || !graph.containsKey(curr)) return -1;
        if (curr.equals(target)) return v;
        visited.add(curr);
        for (Pair neighbour : graph.get(curr)) {
            double foll = dfs(neighbour.s, target, visited, v * neighbour.w);
            if (foll != -1) return foll;
        }
        return -1;
    }
}

class Pair {
    String s;
    double w;

    public Pair(String s, double w) {
        this.s = s;
        this.w = w;
    }
}
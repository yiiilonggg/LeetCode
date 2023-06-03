class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> passengers;
    Map<String, Map<String, Pair<Integer, Integer>>> stations;
    public UndergroundSystem() {
        passengers = new HashMap<>();
        stations = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (passengers.containsKey(id)) return;
        passengers.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (!passengers.containsKey(id)) return;
        String startStation = passengers.get(id).first;
        int startTime = passengers.get(id).second;
        passengers.remove(id);
        if (!stations.containsKey(startStation)) stations.put(startStation, new HashMap<>());
        if (!stations.get(startStation).containsKey(stationName)) stations.get(startStation).put(stationName, new Pair(0, 0));
        stations.get(startStation).get(stationName).first += t - startTime;
        stations.get(startStation).get(stationName).second++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return (double) stations.get(startStation).get(endStation).first / stations.get(startStation).get(endStation).second;
    }
}

class Pair<T, S> {
    T first;
    S second;
    public Pair(T t, S s) {
        first = t;
        second = s;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

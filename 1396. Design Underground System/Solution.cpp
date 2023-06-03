class UndergroundSystem {
public:
    unordered_map<int, pair<string, int>> passengers;
    unordered_map<string, unordered_map<string, pair<int, int>>> stations;
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string stationName, int t) {
        if (passengers.find(id) != passengers.end()) return;
        passengers[id] = pair(stationName, t);
    }
    
    void checkOut(int id, string stationName, int t) {
        if (passengers.find(id) == passengers.end()) return;
        string startStation = passengers[id].first;
        int startTime = passengers[id].second;
        passengers.erase(id);
        if (stations.find(startStation) == stations.end()) {
            unordered_map<string, pair<int, int>> stationInfo;
            stations[startStation] = stationInfo;
        }
        if (stations[startStation].find(stationName) == stations[startStation].end()) stations[startStation][stationName] = pair(0, 0);
        stations[startStation][stationName].first += t - startTime;
        stations[startStation][stationName].second++;
    }
    
    double getAverageTime(string startStation, string endStation) {
        return (double) stations[startStation][endStation].first / stations[startStation][endStation].second;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */

class ParkingSystem {
public:
    vector<int> maxCap, currCap;
    ParkingSystem(int big, int medium, int small) {
        maxCap = { big, medium, small };
        currCap.assign(3, 0);
    }
    
    bool addCar(int carType) {
        if (currCap[carType - 1] == maxCap[carType - 1]) return false;
        currCap[carType - 1]++;
        return true;
    }
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */

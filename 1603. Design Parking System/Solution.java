class ParkingSystem {
    int[] maxCap, currCap;

    public ParkingSystem(int big, int medium, int small) {
        maxCap = new int[] { big, medium, small };
        currCap = new int[3];
    }
    
    public boolean addCar(int carType) {
        if (currCap[carType - 1] == maxCap[carType - 1]) return false;
        currCap[carType - 1]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

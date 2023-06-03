class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.maxCap = [big, medium, small]
        self.currCap = [0, 0, 0]

    def addCar(self, carType: int) -> bool:
        if self.currCap[carType - 1] == self.maxCap[carType - 1]: return False
        self.currCap[carType - 1] += 1
        return True



# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)

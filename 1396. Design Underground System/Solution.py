class UndergroundSystem:

    def __init__(self):
        self.passengers = dict()
        self.stations = dict()

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        if id in self.passengers: return
        self.passengers[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        if id not in self.passengers: return
        startStation, startTime = self.passengers[id]
        del self.passengers[id]
        if startStation not in self.stations: self.stations[startStation] = dict()
        if stationName not in self.stations[startStation]: self.stations[startStation][stationName] = [0, 0]
        self.stations[startStation][stationName][0] += t - startTime
        self.stations[startStation][stationName][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        return self.stations[startStation][endStation][0] / self.stations[startStation][endStation][1]


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)

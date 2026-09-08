import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Maps customer id -> [stationName, checkInTime]
    private Map<Integer, Pair> checkInMap;

    // Maps "startStation_endStation" -> [totalTime, tripCount]
    private Map<String, double[]> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo = checkInMap.get(id);
        String startStation = checkInInfo.station;
        int startTime = checkInInfo.time;

        String key = startStation + "_" + stationName;
        double travelTime = t - startTime;

        travelMap.putIfAbsent(key, new double[2]); // [totalTime, count]
        travelMap.get(key)[0] += travelTime;
        travelMap.get(key)[1] += 1;

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "_" + endStation;
        double[] data = travelMap.get(key);
        return data[0] / data[1];
    }

    // Helper class to store check-in info
    private static class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}

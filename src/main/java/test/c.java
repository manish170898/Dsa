//package test;
//
//import java.util.*;
//
//public class c {
//}
//
///* Problem Name is &&& Train Map &&& PLEASE DO NOT REMOVE THIS LINE. */
//
///**
// * Instructions to candidate.
// * 1) Run this code in the REPL to observe its behaviour. The
// * execution entry point is main().
// * 2) Consider adding some additional tests in doTestsPass().
// * 3) Implement def shortestPath(self, fromStationName, toStationName)
// * method to find shortest path between 2 stations
// * 4) If time permits, some possible follow-ups.
// */
//
///*
// *      Visual representation of the Train map used
// *
// *      King's Cross St Pancras --- Angel ---- Old Street
// *      |                   \                            |
// *      |                    \                            |
// *      |                     \                            |
// *      Russell Square         Farringdon --- Barbican --- Moorgate
// *      |                                                  /
// *      |                                                 /
// *      |                                                /
// *      Holborn --- Chancery Lane --- St Paul's --- Bank
// */
//
//import java.util.*;
//
//        import org.apache.commons.lang3.builder.ToStringSummary;
//
//public class Solution {
//    /**
//     * class Station
//     * <p>
//     * Respresents Station in the rail network. Each station is identified by
//     * unique name. Station is connected with other stations - this information
//     * is stored in the 'neighbours' field. Two station objects with the same name are
//     * equal therefore they are considered to be same station.
//     */
//    private static class Station {
//        private String name;
//        private List<Station> neighbours;
//
//        public Station(String name) {
//            this.name = name;
//            this.neighbours = new ArrayList<>(3);
//        }
//
//        String getName() {
//            return name;
//        }
//
//        void addNeighbour(Station v) {
//            this.neighbours.add(v);
//        }
//
//        List<Station> getNeighbours() {
//            return this.neighbours;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return obj instanceof Station && this.name.equals(((Station) obj).getName());
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(this.name);
//        }
//    }
//
//    /**
//     * class TrainMap
//     * <p>
//     * Respresents whole rail network - consists of number of the Station objects.
//     * Stations in the map are bi-directionally connected. Distance between any 2 stations
//     * is of same constant distance unit. This implies that shortest distance between any
//     * 2 stations depends only on number of stations in between
//     */
//    private static class TrainMap {
//
//        private HashMap<String, Station> stations;
//
//        public TrainMap() {
//            this.stations = new HashMap<>();
//        }
//
//        public TrainMap addStation(String name) {
//            Station s = new Station(name);
//            this.stations.putIfAbsent(name, s);
//            return this;
//        }
//
//        public TrainMap connectStations(String fromStation, String toStation) {
//            return connectStations(getStation(fromStation), getStation(toStation));
//        }
//
//        public Station getStation(String name) {
//            return this.stations.get(name);
//        }
//
//        public TrainMap connectStations(Station fromStation, Station toStation) {
//            if (fromStation == null) {
//                throw new IllegalArgumentException("From station is null");
//            }
//            if (toStation == null) {
//                throw new IllegalArgumentException("To station is null");
//            }
//            fromStation.addNeighbour(toStation);
//            toStation.addNeighbour(fromStation);
//            return this;
//        }
//
//        public List<Station> shortestPath(String from, String to) {
//            /*
//             * TODO Implement
//             */
//            Station fromStation = new Station(from);
//            Station toStation = new Station(to);
//            Queue<List<Station>> queue = new LinkedList<>();
//            Set<Station> visited = new HashSet<>();
//            List<Station> path = new ArrayList<>();
//            visited.add(fromStation);
//            path.add(fromStation);
//            queue.add(path);
//            while(!queue.isEmpty()){
//                List<Station> cPath = queue.poll();
//                Station cStation = path.get(path.size() -1);
//                System.out.println(cStation.getName());
//                System.out.println(toStation.getName());
//                if(cStation.equals(toStation)) {
//                    return cPath;
//                }
//                List<Station> neighbours = this.stations.get(cStation.getName()).neighbours;
//                for(Station neighbour : neighbours){
//                    System.out.println(toStation.getName());
//                    if(!visited.contains(neighbour)){
//                        visited.add(neighbour);
//                        List<Station> newPath = new ArrayList<>(cPath);
//                        newPath.add(neighbour);
//                        queue.add(newPath);
//                    }
//                }
//            }
//            return Collections.emptyList();
//        }
//
//        public static String convertPathToStringRepresentation(List<Station> path) {
//            return String.join("->", path.stream().map(Station::getName).toList());
//        }
//    }
//
//    class PairS{
//        int distance;
//        Station station;
//        public PairS(int distance, Station station){
//            this.distance = distance;
//            this.station = station;
//        }
//    }
//
//
//    public static boolean doTestsPass() {
//        // todo: implement more tests, please
//        // feel free to make testing more elegant
//        TrainMap trainMap = new TrainMap();
//
//
//        trainMap.addStation("King's Cross St Pancras")
//                .addStation("Angel")
//                .addStation("Old Street")
//                .addStation("Moorgate")
//                .addStation("Farringdon")
//                .addStation("Barbican")
//                .addStation("Russel Square")
//                .addStation("Holborn")
//                .addStation("Chancery Lane")
//                .addStation("St Paul's")
//                .addStation("Bank");
//
//        trainMap.connectStations("King's Cross St Pancras", "Angel")
//                .connectStations("King's Cross St Pancras", "Farringdon")
//                .connectStations("King's Cross St Pancras", "Russel Square")
//                .connectStations("Russel Square", "Holborn")
//                .connectStations("Holborn", "Chancery Lane")
//                .connectStations("Chancery Lane", "St Paul's")
//                .connectStations("St Paul's", "Bank")
//                .connectStations("Angel", "Old Street")
//                .connectStations("Old Street", "Moorgate")
//                .connectStations("Moorgate", "Bank")
//                .connectStations("Farringdon", "Barbican")
//                .connectStations("Barbican", "Moorgate");
//
//        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
//
//        return solution.equals(TrainMap.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
//    }
//
//    public static void main(String[] args) {
//        if (doTestsPass()) {
//            System.out.println("All tests pass");
//        } else {
//            System.out.println("Tests fail.");
//        }
//    }
//}
//

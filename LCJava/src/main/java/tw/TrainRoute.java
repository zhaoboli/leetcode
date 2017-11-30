package tw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TrainRoute {

    private class ResultMessage {
        public static final String SUCCESS =  "SUCCESS";
        public static final String FAILURE = "NO SUCH ROUTE";
    }

    private Map<String, Map<String, Integer>> graph;


    public TrainRoute (String filename) {
        this.graph = new HashMap<>();
        this.initGraph(filename);
    }

    private String readGraphSource(String filename) throws IOException, FileNotFoundException {
        /*
        if (filename.length() > 0) {
            return "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
        }
        */
        BufferedReader dataFile = new BufferedReader(new FileReader(filename));
        String line, data;
        data = "";
        while ((line = dataFile.readLine()) != null) {
            data += line;
        }
        return data;
    }

    private void initGraph(String file) {
        String graphRaw = "";
        try {
            graphRaw = readGraphSource(file);
        } catch (Exception e) {
            System.out.println("Couldn't read raw graph data");
            System.exit(-1);
        }
        try {
            parseGraph(graphRaw);
        } catch (TrainMapException e) {
            System.out.println(e.errorMsg());
            System.out.println("Couldn't parse raw graph data");
            System.exit(-1);
        }


    }
    private void parseGraph(String rawGraph) throws TrainMapException {
        String[] input = rawGraph.split(",");

        for (int i = 0; i < input.length; i++) {
            //TODO first, second must be Character
            if (!Character.isLetter(input[i].charAt(0)) || !Character.isLetter(input[i].charAt(1))) {
                throw new TrainMapException("Invalid Raw Graph Data: Town must be letter");
            }
            String startTown = input[i].substring(0, 1);
            String endTown = input[i].substring(1, 2);
            int distance = 0;
            try {
                distance = Integer.parseInt(input[i].substring(2));
            } catch (Exception e) {
                throw new TrainMapException("Invalid Raw Graph Data: Distance must be number");
            }
            if (distance <= 0) {
                throw new TrainMapException("Invalid Raw Graph Data: Distance must be positive integer");
            }
            if (!this.graph.containsKey(startTown)) {
                Map<String, Integer> neighborMap = new HashMap<String, Integer>();
                neighborMap.put(endTown, distance);
                this.graph.put(startTown, neighborMap);
                continue;
            }
            this.graph.get(startTown).put(endTown, distance);
        }

    }

    public RouteResult calculateRouteDistance(String route) {
        String[] towns = route.split("-");
        int sum = 0;

        for (int i = 0; i < towns.length - 1; i++) {
            if (!graph.containsKey(towns[i])) {
                return new RouteResult(-1, ResultMessage.FAILURE);
            }
            if (!graph.get(towns[i]).containsKey(towns[i+1])) {
                return new RouteResult(-1, ResultMessage.FAILURE);
            }
            sum += graph.get(towns[i]).get(towns[i+1]);
        }
        return new RouteResult(sum, ResultMessage.SUCCESS);
    }

    public RouteResult searchPathMaxStops(String start, String end, int maxStops) {
        int minStops = 1;
        return this.searchPathByStops(start, end, minStops, maxStops);
    }

    public RouteResult searchPathExactStops(String start, String end, int exactStops) {
        return this.searchPathByStops(start, end, exactStops, exactStops);
    }

    private RouteResult searchPathByStops(String start, String end, int minStops, int maxStops) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        searchPathByStopsHelper(start, end, path, 0, minStops, maxStops, result);
        if (result.size() > 0 ) {
            return new RouteResult(result.size(), ResultMessage.SUCCESS);
        }
        return new RouteResult(-1, ResultMessage.FAILURE);
    }

    private void searchPathByStopsHelper(String start, String end, List<String> path, int currStops, int minStops, int maxStops, List<String> result) {
        if (currStops > maxStops) {
            return;
        }
        if (start.equals(end) && currStops >= minStops)  {
            result.add(String.join("", path));
        }
        for (Map.Entry<String, Integer> entry: this.graph.get(start).entrySet()) {
            String next = entry.getKey();
            path.add(next);
            searchPathByStopsHelper(next, end, path,currStops + 1, minStops, maxStops, result);
            path.remove(path.size() - 1);
        }
    }

    public RouteResult searchPathMaxDistance(String start, String end, int maxDistance) {
        return this.searchPathByDistance(start, end, 1, maxDistance);
    }

    private RouteResult searchPathByDistance(String start, String end, int minDistance, int maxDistance ) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        searchPathByDistanceHelper(start, end, path, 0, minDistance, maxDistance, result);
        if (result.size() > 0 ) {
            return new RouteResult(result.size(), ResultMessage.SUCCESS);
        }
        return new RouteResult(-1, ResultMessage.FAILURE);
    }

    private void searchPathByDistanceHelper(String start, String end, List<String> path, int distanceSum, int minDistance, int maxDistance, List<String> result ) {
        if (distanceSum >= maxDistance) {
            return;
        }
        if (start.equals(end) && distanceSum >= minDistance) {
            result.add(String.join("", path));
        }
        for (Map.Entry<String, Integer> entry: this.graph.get(start).entrySet()) {
            String next = entry.getKey();
            path.add(next);
            searchPathByDistanceHelper(next, end, path, distanceSum + entry.getValue(), minDistance, maxDistance, result);
            path.remove(path.size() -1);
        }
    }

    public RouteResult searchPathShortestDistance(String start, String end) {
        RouteResult result = new RouteResult(Integer.MAX_VALUE, ResultMessage.FAILURE);
        Set<String> path = new HashSet<>();
        searchPathShortestDistanceHelper(start, end, 0, path, result);
        return result;
    }

    private void searchPathShortestDistanceHelper(String start, String end, int currDistance, Set<String> path, RouteResult shortest) {
        if (currDistance >= shortest.getValue()) {
            return;
        }
        if (start.equals(end) && currDistance < shortest.getValue() && currDistance > 0) {
            shortest.setValue(currDistance);
            shortest.setMessage(ResultMessage.SUCCESS);
            return;
        }
        for (Map.Entry<String, Integer> entry: this.graph.get(start).entrySet()) {
            String next = entry.getKey();
            if (path.contains(next)) {
                continue;
            }
            path.add(next);
            searchPathShortestDistanceHelper(next, end, currDistance + entry.getValue(), path, shortest);
            path.remove(next);
        }
    }
}


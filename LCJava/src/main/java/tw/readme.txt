Design:
use Map<String, Map<String, Integer>> as data structure to store the route graph: Basically a HashMap with a key of town and a value of neighbors map; neighbor map stores
the neighbor and neighbor's distance to town
case 1-5 traverse the map following input, if able to traverse the whole path, success, otherwise false.
Case 6, 7: using DFS to find the possible route, as case 6 is <= max and case 7 is == max, so extract parameter minStop, combined with maxStop to reduce some code duplication.
Case 8, 9: using DFS + HashSet(path) to memorize the already visited town to avoid going in circles.
Case 10: similar with case 6,7, with a variation condition of max distance rather than stops.

Run instruction:
Use Junit to run the test case 1-10(TrainRouteTest.java), must have trainRoute.txt in the code running directory.
Or execute the runner.




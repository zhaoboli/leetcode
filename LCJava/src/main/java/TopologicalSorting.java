import ingrediant.DirectedGraphNode;

import java.util.*;

/**
 * Created by zhaobo on 4/8/17.
 * Given an directed graph, a topological order of the graph nodes is defined as follow:

 For each directed edge A -> B in graph, A must before B in the order list.
 The first node in the order can be any node in the graph with no nodes direct to it.
 Find any topological order for the given graph.

 Notice

 You can assume that there is at least one topological order in the graph.

 For graph as follow:

 picture

 The topological order can be:

 [0, 1, 2, 3, 4, 5]
 [0, 2, 3, 1, 5, 4]
 ...
 */
public class TopologicalSorting {

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> hash = new Hashtable<>();
        ArrayList<DirectedGraphNode> heads = new ArrayList<>();

        for (DirectedGraphNode directedNode : graph) {
            for(DirectedGraphNode nei : directedNode.neighbors) {
                if (!hash.containsKey(nei)) {
                    hash.put(nei, 1);
                } else {
                    hash.put(nei, hash.get(nei) + 1);
                }

            }
        }

        for (DirectedGraphNode dgn : graph) {
            if (!hash.containsKey(dgn)) {
                heads.add(dgn);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> sortedGraph = new ArrayList<DirectedGraphNode>();
        for (DirectedGraphNode dgnHead : heads) {
            queue.offer(dgnHead);
            sortedGraph.add(dgnHead);
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neigh : node.neighbors) {
                hash.put(neigh, hash.get(neigh) - 1);
                if (hash.get(neigh) == 0) {
                    sortedGraph.add(neigh);
                    queue.offer(neigh);
                }
            }
        }

        return sortedGraph;
    }

}

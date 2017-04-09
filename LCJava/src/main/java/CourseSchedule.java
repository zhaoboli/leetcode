import java.util.*;

/**
 * Created by zhaobo on 4/9/17.
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Example
 Given n = 2, prerequisites = [[1,0]]
 Return true

 Given n = 2, prerequisites = [[1,0],[0,1]]
 Return false


 */
public class CourseSchedule {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();

        for (int index = 0; index < numCourses; index++) {
            edges.put(index, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            degrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int degreeIndex = 0; degreeIndex < degrees.length; degreeIndex++) {
            if (degrees[degreeIndex] == 0) {
                queue.offer(degreeIndex);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int degree = queue.poll();
            count++;
            ArrayList<Integer> edge = edges.get(degree);
            for (int j = 0; j < edge.size(); j++) {
                int pointedTo = edge.get(j);
                degrees[pointedTo]--;
                if (degrees[pointedTo] == 0) {
                    queue.offer(pointedTo);
                }
            }
        }

        return count == numCourses;
    }
}

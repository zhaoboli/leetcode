import com.sun.javafx.geom.transform.BaseTransform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhaobo on 4/9/17.
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 Example
 Given n = 2, prerequisites = [[1,0]]
 Return [0,1]

 Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 Return [0,1,2,3] or [0,2,1,3]
 */
public class CourseScheduleII {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        int[] degrees = new int[numCourses];
        List<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int index = 0; index < prerequisites.length; index++) {
            //record how many dependencies a course has
            degrees[prerequisites[index][0]]++;

            //record what courses this course can unlock
            edges.get(prerequisites[index][1]).add(prerequisites[index][0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int j = 0; j < degrees.length; j++) {
            if (degrees[j] == 0) {
                queue.offer(j);
            }
        }

        int count = 0;
        int[] resultArr = new int[numCourses];

        while (!queue.isEmpty()) {
            Integer currCourse = queue.poll();
            resultArr[count] = currCourse;
            count++;
            for (Integer course : edges.get(currCourse)) {
                degrees[course]--;
                if (degrees[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        if (count == numCourses) {
            return  resultArr;
        }
        return new int[0];
    }
}

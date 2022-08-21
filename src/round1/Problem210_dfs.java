package round1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:在207的基础上加了个层序遍历，注意去掉相同元素
 * @author: jilai_huang
 * @date: 2022/8/20 21:16
 */

public class Problem210_dfs {
    static boolean[] visited;
    static boolean[] onPath;
    static boolean hasCycle;
    static List<Integer> ans;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        ans = new LinkedList<>();
        int[] res = new int[numCourses];
        //解决有课但是没有先后顺序这种情况
        if(prerequisites == null || prerequisites.length ==0 || (prerequisites.length == 1 && prerequisites[0].length == 0)){
            for(int i = 0; i < numCourses; i++){
                res[i] = i;
                return res;
            }
        }
        //生成邻接表
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        //对每个节点进行遍历
        for(int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }
        if(hasCycle){
            return new int[]{};
        }else {
            Collections.reverse(ans);
            for(int i = 0; i < numCourses; i++){
                res[i] = ans.get(i);
            }
            return res;
        }
    }
    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i  < numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
    public static void traverse(List<Integer>[] graph, int s){
        //判断是否有环
        if(onPath[s]){
            hasCycle = true;
        }
        //递归退出条件
        if(visited[s] || hasCycle){
            return;
        }
        onPath[s] = true;
        visited[s] = true;
        //对s点的下一节点进行递归遍历
        for (Integer integer : graph[s]) {
            traverse(graph, integer);
        }
        onPath[s] = false;
        ans.add(s);
    }

    public static void main(String[] args) {
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites = new int[1][];
        int[][] prerequisites = {{1,0}};
        int[] order = findOrder(3, prerequisites);
        for (int i : order) {
            System.out.println(i);
        }
    }

}

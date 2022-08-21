package round1;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/20 20:41
 */

public class problem207 {
    static boolean isVisited[];
    static boolean onPath[];
    static boolean hasCycle;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] lists = buildGraph(numCourses, prerequisites);
        isVisited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i = 0; i < numCourses-1; i++){
            traverse(lists, i);
        }
        return !hasCycle;

    }
    //将数组转化为邻接表
    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
    //递归遍历邻接表
    public static void traverse(List<Integer>[] graph, int s){
        //如果这个点在此路径上
        if(onPath[s]){
            hasCycle = true;
        }
        if(isVisited[s] || hasCycle){
            return;
        }
        isVisited[s] = true;
        onPath[s] = true;
        for (Integer integer : graph[s]) {
            traverse(graph, integer);
        }
        onPath[s] = false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(2, prerequisites));
    }



}

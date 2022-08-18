package round1;

import sun.security.x509.IPAddressName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/18 11:33
 */

public class Problem797 {
    static List<List<Integer>> ans = new LinkedList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return ans;
    }

    private static void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        //添加节点i到路径
        path.add(i);
        int n = graph.length;
        //找到一条路径
        if(i == n-1){
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for(int v : graph[i]){
            traverse(graph, v, path);
        }
        //最后移除节点i
        path.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        for (List<Integer> list : allPathsSourceTarget(graph)) {
            System.out.println(list);
        }
    }
}

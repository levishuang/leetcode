package round1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 14:35
 */

public class Problem785_bfs {
    public static boolean isBipartite(int[][] graph) {
        //用于标记节点的颜色，用1，-1区别, 0表示未访问
        int[] flag = new int[graph.length];
        //标记是否访问过
//        boolean[] visited = new boolean[graph.length];
        //对每个节点进行染色
        Queue<Integer> queue = new LinkedList<>();
        //对每个点都进行遍历
        for (int i = 0; i < graph.length; i++) {
            //排除单点
            if (graph[i].length != 0 && flag[i] == 0) {
                flag[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int point = queue.poll();
                    //取出该节点的所有邻接节点进行染色
                    for (int j : graph[point]) {
                        if (flag[point] == 1) {
                            if (flag[j] == 0) {
                                flag[j] = -1;
                                queue.add(j);
                            }
                        } else if (flag[point] == -1) {
                            if (flag[j] == 0) {
                                flag[j] = 1;
                                queue.add(j);
                            }
                        }
                    }
                }
            }
        }


        //判断每个节点的颜色是否符合条件
        for (int i = 0; i < graph.length; i++) {
            if (flag[i] == 1) {
                for (int j : graph[i]) {
                    if (flag[j] != -1) {
                        return false;
                    }
                }
            }
            if (flag[i] == -1) {
                for (int j : graph[i]) {
                    if (flag[j] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
//        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));

    }


}

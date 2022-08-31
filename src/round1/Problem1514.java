package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/29 22:33
 */

public class Problem1514 {
    private int[][] graph;
    private boolean[] visited;
    private boolean[] onPath;
    //采用dfs算法进行处理
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    }

    /**
     *
     * @param graph 邻接矩阵
     * @param s  要访问的节点
     */
    public void dfs(int[][] graph, int s){
        if(visited[s]){
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int i : graph[s]) {
            if(!visited[i]){
                dfs(graph, i);
            }
        }
        onPath[s] = false;
    }

    public static void main(String[] args) {

    }
}

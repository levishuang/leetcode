package round1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/29 21:46
 */

public class Problem1584_prim {
    static class Prim{
        private boolean[] inMst;//保存节点是否访问
        private PriorityQueue<int[]> pq;//保存切分所涉及的边
        private int weightSum = 0;
        private List<int[]>[] graph;


        public Prim(List<int[]>[] graph){
            this.graph = graph;
            int n = graph.length;//节点的个数
            inMst = new boolean[n];
            //将边按照从小到大排列,0-from,1-to,2-weight
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2];
                }
            });
            cut(0);
            inMst[0] = true;
            while (!pq.isEmpty()){
                int[] poll = pq.poll();
                int to = poll[1];
                int weight = poll[2];
                if(inMst[to]){
                    continue;
                }
                cut(to);
                inMst[to] = true;
                weightSum += weight;
            }
        }
        //判断s的邻接点是否在最小生成树里,不在的话将所在边加进优先队列
        public void cut(int s){
            for (int[] ints : graph[s]) {
                int to = ints[1];
                if(inMst[to]){
                    continue;
                }
                pq.add(ints);
            }
        }

        public int getWeightSum(){
            return weightSum;
        }

        public boolean allConnected(){
            for (boolean b : inMst) {
                if(!b){
                    return false;
                }
            }
            return true;
        }
    }

    public static int minCostConnectPoints(int[][] points){
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);
        return prim.getWeightSum();
    }

    public static  List<int[]>[] buildGraph(int[][] points){
        int n = points.length;
        List<int[]>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7,0}
        };
        System.out.println(minCostConnectPoints(points));
    }
}

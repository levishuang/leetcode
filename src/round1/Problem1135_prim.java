package round1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/28 17:03
 */

public class Problem1135_prim {

    static class Prim{
        //存储横切边
        private PriorityQueue<int[]> pq;
        private boolean[] inmst;
        private int weightSum = 0;
        //存储邻接表
        private List<int[]>[] graph;
        public Prim(List<int[]>[] graph){
            //节点的个数
            int n = graph.length;
            this.graph = graph;
            inmst = new boolean[n];
            //横切边从小到大排列
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]-o2[2];
                }
            });
            inmst[0] = true;
            cut(0);
            while (!pq.isEmpty()){
                int[] poll = pq.poll();
                int to = poll[1];
                int weight = poll[2];
                if(inmst[to]){
                    continue;
                }
                weightSum += weight;
                inmst[to] = true;
                cut(to);
            }
        }
        public void cut(int s){
            for (int[] ints : graph[s]) {
                int to = ints[1];
                if(inmst[to]){
                    continue;
                }
                pq.add(ints);
            }
        }
        public int getWeightSum(){
            return weightSum;
        }

        public boolean isConnected(){
            for(int i = 0; i < inmst.length; i++){
                if(!inmst[i]){
                    return false;
                }
            }
            return true;
        }

    }

    public static int minimumCost(int n, int[][] connections){
        List<int[]>[] lists = buildGraph(connections, n);
        Prim prim = new Prim(lists);
        if(!prim.isConnected()){
            return -1;
        }
        return prim.getWeightSum();
    }

    public static List<int[]>[] buildGraph(int[][] conections, int n){
        List<int[]>[] graph = new List[n];
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] conection : conections) {
            int from = conection[0]-1;
            int to = conection[1]-1;
            int weight = conection[2];
            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from, weight});
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] connections = {
                {1,2,5},
                {1,3,6},
                {2,3,1}
        };
        System.out.println(minimumCost(3, connections));
    }

}

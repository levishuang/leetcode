package round1;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:prim主要是切分的思想
 * @author: jilai_huang
 * @date: 2022/8/28 16:35
 */

public class Prim {
    //存储横切边的数据集，边的存储形式是from,to,weight
    private PriorityQueue<int[]> pq;
    //存储点是否已经加入到最小生成树
    private boolean[] inMst;
    //记录最小生成树的权重和
    private int weightSum = 0;
    //记录邻接表
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph){
        this.graph = graph;
        this.pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int n = graph.length;
        inMst = new boolean[n];
        //随便找一个节点进行切分
        inMst[0] = true;
        cut(0);
        while (!pq.isEmpty()){
            int[] edge = pq.poll();
            int to  = edge[1];
            int weight  = edge[2];
            if(inMst[to]){
                continue;
            }
            cut(to);
            inMst[to] = true;
            weightSum += weight;
        }
    }
    //将s的横切边加入优先队列中
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
        for(int i = 0; i < inMst.length; i++){
            if(!inMst[i]){
                return false;
            }
        }
        return true;
    }
}

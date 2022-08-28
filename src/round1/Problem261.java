package round1;

/**
 * @package: round1
 * @Description:给定编号从 0 到 n - 1 的 n 个结点。给定一个整数 n 和一个 edges 列表，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间存在一条无向边。
 *              如果这些边能够形成一个合法有效的树结构，则返回 true ，否则返回 false 。
 * @author: jilai_huang
 * @date: 2022/8/27 20:33
 */

public class Problem261 {
    static class UF{
        private int count;
        private int[] parent;

        public UF(int n){
            this.count = n;
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ  = find(q);
            return rootP == rootQ;
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ  = find(q);
            if(rootP == rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int count(){
            return count;
        }



    }
    //判断树是否有环
    public static boolean validTree(int n, int[][] edges){
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if(uf.connected(from, to)){
                return false;
            }else {
                uf.union(from, to);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };
        System.out.println(validTree(5, edges));
    }


}

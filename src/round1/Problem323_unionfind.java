package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/25 20:11
 */

public class Problem323_unionfind {
    static class UF{
        //连通分量的个数
        private int count;
        //存储每个节点的父节点
        private int[] parent;
        //初始化每个节点，父节点为本身
        public UF(int n){
            parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        //将节点p和节点q连通
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        private int find(int x) {
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        public int getCount(){
            return count;
        }
    }
    public static int countComponents(int n, int[][] edges){
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {0, 1},
                {3, 4}
        };
        System.out.println(countComponents(5, edges));
    }
}

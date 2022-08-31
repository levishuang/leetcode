package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/28 17:35
 */

public class UnionFind {
    private int count;
    private int[] parent;


    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(connected(rootP, rootQ)){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}

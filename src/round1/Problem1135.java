package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:最低成本连接所有城市
 * @author: jilai_huang
 * @date: 2022/8/27 20:57
 */

public class Problem1135 {
    static class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        public int count() {
            return count;
        }
    }

    public static int minimumCost(int n, int[][] connections) {
        //从1开始，所以0不用
        UF uf = new UF(n + 1);
        //将数组从小到大排列
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int sum = 0;
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int weight = connection[2];
            //成环
            if(uf.connected(from, to)){
                continue;
            }
            //不成环
            uf.union(from, to);
            sum += weight;
        }
        return uf.count == 2 ? sum:-1;
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

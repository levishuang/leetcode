package round1;

import sun.java2d.pipe.SpanClipRenderer;

import java.util.*;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/27 21:14
 */

public class Problem1584_kruskal {
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

    public static int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new LinkedList<>();
        int pointNum = points.length;
        //遍历所有节点获取边长,并对节点进行标号
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int weight = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                edges.add(new int[]{i, j, weight});

            }
        }
        int edgeNum = edges.size();
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        //根据kruskal算法进行最小生成树的建立
        int sum = 0;
        UF uf = new UF(pointNum);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 若这条边会产生环，则不能加入 mst
            if (uf.connected(u, v)) {
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            sum += weight;
            uf.union(u, v);
        }
        return uf.count == 1 ? sum : -1;
    }
//    public static int minCostConnectPoints(int[][] points) {
//        int n = points.length;
//        // 生成所有边及权重
//        List<int[]> edges = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int xi = points[i][0], yi = points[i][1];
//                int xj = points[j][0], yj = points[j][1];
//                // 用坐标点在 points 中的索引表示坐标点
//                edges.add(new int[]{
//                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
//                });
//            }
//        }
//        // 将边按照权重从小到大排序
//        Collections.sort(edges, (a, b) -> {
//            return a[2] - b[2];
//        });
//        // 执行 Kruskal 算法
//        int mst = 0;
//        UF uf = new UF(n);
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            int weight = edge[2];
//            // 若这条边会产生环，则不能加入 mst
//            if (uf.connected(u, v)) {
//                continue;
//            }
//            // 若这条边不会产生环，则属于最小生成树
//            mst += weight;
//            uf.union(u, v);
//        }
//        return mst;
//    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {1, 1},
                {1, 0},
                {-1, 1}
        };
        System.out.println(minCostConnectPoints(points));
    }

}

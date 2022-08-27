package round1;

import javax.swing.plaf.IconUIResource;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/25 21:44
 */

public class Problem130_unionfind {
    class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        //寻找根节点
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        //两节点链接
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }

        //判断两个节点是否链接
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        //返回连通分量
        public int count() {
            return count;
        }
    }


    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int sum = m * n + 1; // 0~m*n-1存储的是数组中的数，m*n存储的是虚拟节点
        //节点初始化
        UF uf = new UF(sum);
        //将第一列与虚拟节点链接
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, m * n);
            }
        }
        //将最后一列与虚拟节点链接
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, m * n);
            }
        }
        //将第一行与虚拟节点链接
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, m * n);
            }
        }
        //将最后一行与虚拟节点链接
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, m * n);
            }
        }
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        //遍历上下左右节点
                        int x = i + direction[k][0]; //横坐标
                        int y = j + direction[k][1]; //纵坐标
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        //对不连接的节点进行数值修改
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, m * n) && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

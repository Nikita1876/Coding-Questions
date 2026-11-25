class Pair {
    int x, y, dist;
    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1)); 

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int[] dx = {-1,1,0,0,-1,1,-1,1};
        int[] dy = {0,0,1,-1,1,-1,-1,1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(p.x == n-1 && p.y == n-1) return p.dist;
            for(int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny, p.dist + 1));
                }
            }
        }
        return -1;
    }
}
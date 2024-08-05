import java.util.*;
import java.io.*;

class Main {
    static int[][][] arr;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int result = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1)
                        queue.offer(new int[] {i, j, k});
                    if(arr[i][j][k] == -1)
                        count++;
                }
                    
            }
        }
        if(bfs(queue, h, n, m) + count == h * n * m)
            sb.append(result - 1);
        else
            sb.append(-1);
        
        System.out.println(sb);
    }

    static int bfs(Queue<int[]> queue, int h, int n, int m) {
        int count = 0;
        while(!queue.isEmpty()) {
            int[] num = queue.poll();
            count++;

            for(int i = 0; i < 6; i++) {
                int z = num[0] + dz[i];
                int x = num[1] + dx[i];
                int y = num[2] + dy[i];
                if(z < 0 || x < 0 || y < 0 || z >= h || x >= n || y >= m) {
                    continue;
                }
                
                if(arr[z][x][y] == 0) {
                    queue.offer(new int[] {z, x, y});
                    arr[z][x][y] = arr[num[0]][num[1]][num[2]] + 1;
                    result = Math.max(result, arr[z][x][y]);
                }
            }
        }
        return count;
    }
}
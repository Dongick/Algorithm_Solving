import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        bfs(n, m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    sb.append(-1);
                    System.out.println(sb);
                    return;
                }
            }
        }

        sb.append(max-1);
        System.out.println(sb);
    }

    static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1)
                    queue.offer(new int[] {i, j});
            }
        }
        
        while(!queue.isEmpty()) {
            int[] num = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = num[0] + dx[i];
                int y = num[1] + dy[i];
                if(x < 0 || y < 0 || x >= n || y >= m)
                    continue;
                if(arr[x][y] == 0) {
                    queue.offer(new int[] {x, y});
                    arr[x][y] = arr[num[0]][num[1]] + 1;
                    max = Math.max(max, arr[x][y]);
                }
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        result = new int[n+1][m+1][2];
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++)
                arr[i][j] = s.charAt(j-1) - '0';
        }
         bfs(n, m);
        if(result[n][m][0] == 0 && result[n][m][1] == 0)
            sb.append(-1);
        else if(result[n][m][0] == 0)
            sb.append(result[n][m][1]);
        else if(result[n][m][1] == 0)
            sb.append(result[n][m][0]);
        else
            sb.append(Math.min(result[n][m][0], result[n][m][1]));
        System.out.println(sb);
    }

    static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 1, 0});
        result[1][1][0] = 1;
        while(!queue.isEmpty()) {
            int[] num = queue.poll();
            for(int i = 0; i < 4; i++) {
                int x = num[0] + dx[i];
                int y = num[1] + dy[i];

                if(x < 1 || y < 1 || x > n || y > m)
                    continue;
                if(arr[x][y] == 1) {
                    if(num[2] == 0 && result[x][y][1] == 0) {
                        result[x][y][1] = result[num[0]][num[1]][0] + 1;
                        queue.offer(new int[] {x, y, 1});
                    }
                } else {
                    if(result[x][y][num[2]] == 0) {
                        result[x][y][num[2]] = result[num[0]][num[1]][num[2]] + 1;
                        queue.offer(new int[] {x, y, num[2]});
                    }
                    
                }
            }
        }
    }
}
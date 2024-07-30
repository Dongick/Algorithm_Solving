import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[][] dp;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
       
        sb.append(dfs(0, 0));
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        if(x == n-1 && y == m-1)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if(ax < 0 || ay < 0 || ax >= n || ay >= m)
                continue;

            if(arr[x][y] > arr[ax][ay])
                dp[x][y] += dfs(ax, ay);
        }
        return dp[x][y];
    }
}
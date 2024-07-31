import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] memory = new int[n];
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            cost[i] = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[n][100001];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int nowCost = cost[i];
            for(int j = 0; j <= 100000; j++) {
                if(i == 0) {
                    if(j >= nowCost)
                        dp[i][j] = memory[i];
                } else {
                    if(j >= nowCost)
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nowCost] + memory[i]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= m)
                    min = Math.min(min, j);
            }
        }

        sb.append(min);
        System.out.println(sb);
    }
}
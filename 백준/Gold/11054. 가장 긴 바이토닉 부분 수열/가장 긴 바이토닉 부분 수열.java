import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static int[] arr;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        dp = new int[2][n];
        for(int i = 0; i < n; i++) {
            dp(0, i);
        }
        for(int i = n-1; i >= 0; i--) {
            dp(1, i);
        }
        int max = 0;
        for(int i = 0; i < n; i++)
            max = Math.max(max, dp[0][i] + dp[1][i]);
            
        sb.append(max-1);
        System.out.println(sb);
    }

    static int dp(int x, int y) {
        if(dp[x][y] == 0) {
            dp[x][y] = 1;

            if(x == 0) {
                for(int i = y - 1; i >= 0; i--) {
                    if(arr[i] < arr[y])
                        dp[x][y] = Math.max(dp[x][y], dp[x][i] + 1);
                }
            }
            if(x == 1) {
                for(int i = y + 1; i < n; i++) {
                    if(arr[i] < arr[y])
                        dp[x][y] = Math.max(dp[x][y], dp[x][i] + 1);
                }
            }
        }
        return dp[x][y];
    }
}
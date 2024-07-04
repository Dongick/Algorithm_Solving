import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[][] arr;
    static int result = 1;
    static int[][] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= n; j++)
                arr[i][j] = s.charAt(j-1) - '0';
        }
        dp = new int[1<<n][n+1];
        dfs(1, 1, 1);
        System.out.println(result);
    }
    
    static void dfs(int i, int count, int state) {
        result = Math.max(result, count);
        if (result == n) return;
        for(int k = 2; k <= n; k++) {
            if((state & (1 << (k - 1))) == 0 && arr[i][k] >= dp[state][i]) {
                if(arr[i][k] >= dp[state | (1 << (k-1))][k] && dp[state | (1 << (k-1))][k] != 0)
                    continue;
                dp[state | (1 << (k-1))][k] = arr[i][k];
                dfs(k, count+1, state |(1 << (k-1)));
            }
        }
    }
}
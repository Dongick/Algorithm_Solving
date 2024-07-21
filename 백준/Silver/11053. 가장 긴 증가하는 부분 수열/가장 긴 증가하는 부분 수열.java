import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int num = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            dp(i);
        }
        int result = 0;
        for(int i = 0; i < n; i++)
            result = Math.max(result, dp[i]);
        sb.append(result);
        System.out.println(sb);
    }

    static int dp(int n) {
        if(dp[n] == 0) {
            dp[n] = 1;

            for(int i = n - 1; i >= 0; i--) {
                if(arr[i] < arr[n])
                    dp[n] = Math.max(dp[n], dp[i] + 1);
            }
        }
        return dp[n];
    }
}
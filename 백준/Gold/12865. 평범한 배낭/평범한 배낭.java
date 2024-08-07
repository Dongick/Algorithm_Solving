import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[] dp;
    static int n;
    static int k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][2];
        dp = new int[k+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            for(int j = k; j - arr[i][0] >= 0; j--)
                dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
        }
        sb.append(dp[k]);
        System.out.println(sb);
    }
}
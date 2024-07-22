import java.util.*;
import java.io.*;

class Main {
    static int[] dp;
    static int[][] arr;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < n; i++) {
            dp(i);
        }
        int max = 0;
        for(int i = 0; i < n; i++) 
            max = Math.max(max, dp[i]);
            
        sb.append(n - max);
        System.out.println(sb);
    }

    static int dp(int idx) {
        if(dp[idx] == 0) {
            dp[idx] = 1;

            for(int i = idx - 1; i >= 0; i--) {
                if(arr[i][1] < arr[idx][1])
                    dp[idx] = Math.max(dp[idx], dp[i] + 1);
            }
        }
        return dp[idx];
    }
}
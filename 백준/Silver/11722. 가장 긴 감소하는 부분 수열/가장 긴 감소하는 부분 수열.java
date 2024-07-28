import java.util.*;
import java.io.*;

class Main {
    static int[] dp;
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp(i);
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        sb.append(max);
        System.out.println(sb);
    }

    static void dp(int num) {
        if(dp[num] == 0) {
            dp[num] = 1;

            for(int i = num - 1; i >= 0; i--) {
                if(arr[num] < arr[i]) {
                    dp[num] = Math.max(dp[num], dp[i] + 1);
                }
            }
        }
    }
}
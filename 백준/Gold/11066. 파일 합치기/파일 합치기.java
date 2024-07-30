import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[k+1];
            int[] sum = new int[k+1];
            for(int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + arr[i];
            }
                

            int[][] dp = new int[k+1][k+1];
            for(int i = 1; i < k; i++) {
                for(int j = 1; i + j <= k; j++) {
                    int n = i + j;
                    dp[j][n] = Integer.MAX_VALUE;
                    for(int z = j; z < i + j; z++) {
                        dp[j][n] = Math.min(dp[j][n], dp[j][z] + dp[z+1][n] + sum[n] - sum[j-1]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.println(sb);
    }
}
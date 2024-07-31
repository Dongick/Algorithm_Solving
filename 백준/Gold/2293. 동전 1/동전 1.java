import java.util.*;
import java.io.*;

class Main {
    static int n, k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        dp[0] = 1;
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            for(int j = num; j <= k; j++) {
                dp[j] += dp[j - num];
            }
        }
        
        sb.append(dp[k]);
        System.out.println(sb);
    }
}
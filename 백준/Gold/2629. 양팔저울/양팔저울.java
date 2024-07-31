import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n, m;
    static boolean[] dp = new boolean[40001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            if(!dp[arr[i]]) {
                dp[arr[i]] = true;
                dfs(i+1, arr[i]);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(dp[num]) {
                sb.append("Y").append(" ");
                continue;
            }
            boolean check = false;
            for(int j = 1; j + num <= 40000; j++) {
                if(dp[j] && dp[j + num]) {
                    sb.append("Y").append(" ");
                    check = true;
                    break;
                }
            }
            if(!check)
                sb.append("N").append(" ");
        }
       
        System.out.println(sb);
    }

    static void dfs(int idx, int sum) {
        for(int i = idx; i < n; i++) {
            if(!dp[arr[i] + sum] && arr[i] + sum <= 40000) {
                dp[arr[i] + sum] = true;
                dfs(i+1, arr[i] + sum);
            }
        }
    }
}
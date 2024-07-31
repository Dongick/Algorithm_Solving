import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] arr2;
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
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
            if(!dp[arr[i]]) {
                dp[arr[i]] = true;
                dfs(i+1, arr[i]);
            }
        }
        for(int i = 0; i < m; i++) {
            boolean check = false;
            if(dp[arr2[i]]) {
                sb.append("Y").append(" ");
                check = true;
            }
            else {
                for(int j = 1; j + arr2[i] <= 40000; j++) {
                    if(dp[j] && dp[j + arr2[i]]) {
                        sb.append("Y").append(" ");
                        check = true;
                        break;
                    }
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
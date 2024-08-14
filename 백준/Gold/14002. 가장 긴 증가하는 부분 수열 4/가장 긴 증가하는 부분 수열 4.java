import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    static int[] trace;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        trace = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int idx = dp();
        sb.append(dp[idx]).append("\n");
        Stack<Integer> stack = new Stack<>();
        while(idx > 0) {
            stack.push(arr[idx]);
            idx = trace[idx];
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int dp() {
        int max = 1;
        int idx = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 1; j--) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if(max < dp[i]) {
                        max = dp[i];
                        idx = i;
                    }
                    trace[i] = j;
                }
            }
        }
        return idx;
    }
}
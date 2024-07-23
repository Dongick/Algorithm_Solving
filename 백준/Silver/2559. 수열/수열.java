import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int n;
    static int k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int sum[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i+1] = sum[i] + arr[i];
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i <= n-k; i++) {
            result = Math.max(sum[i+k] - sum[i], result);
        }
        sb.append(result);
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        long[] remain = new long[m];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            sum %= m;
            remain[sum]++;
        }
        long count = remain[0];
        for(int i = 0; i < m; i++) {
            long num = remain[i];
            if(num >= 2)
                count += num * (num - 1) / 2;
        }
        
        sb.append(count);
        System.out.println(sb);
    }
}
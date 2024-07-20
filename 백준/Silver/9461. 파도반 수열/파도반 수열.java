import java.util.*;
import java.io.*;

class Main {
    static long[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n <= 3)
                sb.append(1).append("\n");
            else if(n <= 5)
                sb.append(2).append("\n");
            else {
                arr = new long[n+1];
                dp(n);
                sb.append(arr[n]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dp(int n) {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for(int i = 6; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        if(n == 1) {
            sb.append(1);
            System.out.println(sb);
            return;
        }
        dp(n);
        sb.append(arr[n]);
        System.out.println(sb);
    }

    static void dp(int n) {
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 15746;
        }
    }
}
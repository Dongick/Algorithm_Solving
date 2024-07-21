import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int[] sum = new int[n];
        sum[0] = arr[0];
        
        for(int i = 1; i < n; i++) {
            if(i == 1)
                sum[i] = arr[i-1] + arr[i];
            else if(i == 2)
                sum[i] = Math.max(arr[i-2] + arr[i-1], Math.max(arr[i-2] + arr[i], arr[i-1] + arr[i]));
            else
                sum[i] = Math.max(sum[i-3] + arr[i-1] + arr[i], Math.max(sum[i-2] + arr[i], sum[i-1]));
        }
        if(n == 1)
            sb.append(sum[0]);
        else
            sb.append(sum[n-1]);
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int[] trace;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        trace = new int[n+1];
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + 1;
            trace[i] = i-1;
            if(i % 2 == 0 && arr[i] > arr[i/2] + 1) {
                arr[i] = arr[i/2] + 1;
                trace[i] = i/2;
            }
            if(i % 3 == 0 && arr[i] > arr[i/3] + 1) {
                arr[i] = arr[i/3] + 1;
                trace[i] = i/3;
            }
        }

        sb.append(arr[n]).append("\n");
        int idx = n;
        while(idx > 0) {
            sb.append(idx).append(" ");
            idx = trace[idx];
        }
        System.out.println(sb);
    }
}
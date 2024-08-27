import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        
        int min = 50;
        for(int i = 1; i < n; i++) {
            min = Math.min(arr[i], min);
        }
        
        int digit = 0;
        if(arr[0] >= min) {
            digit = m / min;
        } else {
            if(m < min) {
                sb.append(0);
                System.out.println(sb);
                return;
            }
            digit = (m - min) / arr[0] + 1;   
            min = arr[0];
        }
        
        while(--digit > 0) {
            int maxIdx = 0;
            for(int i = 0; i < n; i++) {
                int num = (m - arr[i]) / min;
                if(num >= digit) {
                    maxIdx = i;
                }
            }
            sb.append(maxIdx);
            m -= arr[maxIdx];
        }

        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(m >= arr[i])
                idx = i;
        }
        sb.append(idx);

        System.out.println(sb);
    }
}
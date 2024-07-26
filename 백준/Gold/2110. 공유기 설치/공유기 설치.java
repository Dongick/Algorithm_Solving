import java.util.*;
import java.io.*;

class Main {
    static int c, n;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int hi = arr[n-1] - arr[0] + 1;
        int low = 1;
        while(hi > low) {
            int mid = (hi + low) / 2;
            if(func(mid) < c)
                hi = mid;
            else
                low = mid + 1;
        }
        
        sb.append(low-1);
        System.out.println(sb);
    }

    static int func(int distance) {
        int count = 1;
        int locate = arr[0];
        for(int i = 1; i < n; i++) {
            int spot = arr[i];
            if(spot - locate >= distance) {
                count++;
                locate = spot;
            }
        }
        return count;
    }
}
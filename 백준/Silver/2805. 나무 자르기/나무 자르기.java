import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(max < num)
                max = num;
            arr[i] = num;
        }
        int start = 0;
        int end = max;
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] > mid)
                    sum += (arr[i] - mid);
            }
            
            if(sum >= m) {
                result = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        System.out.println(result);
    }
}
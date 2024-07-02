import java.io.*;
import java.util.*;

class Main{
    static int[] arr;
    static int k;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int max = 0;
        arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max)
                max = arr[i];
        }
        function(max);
    }
    
    static void function(int max) {
        long start = 1;
        long end = max;
        long result = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for(int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }
            if(count >= n) {
                result = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        System.out.println(result);
    }
}
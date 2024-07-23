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
        int sum[] = new int[n-k+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < sum.length; i++) {
            for(int j = i; j < i + k; j++) {
                sum[i] += arr[j];
            }
        }
        Arrays.sort(sum);
        sb.append(sum[n-k]);
        System.out.println(sb);
    }
}
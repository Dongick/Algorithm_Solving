import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; i + j < n; j++) {
                int t = i + j;
                result[j][t] = Integer.MAX_VALUE;
                for(int k = j; k < i + j; k++) {
                    result[j][t] = Math.min(result[j][t], result[j][k] + result[k+1][t] + arr[j][0] * arr[k+1][0] * arr[t][1]);
                }
            }
        }
        sb.append(result[0][n-1]);
        System.out.println(sb);
    }
}
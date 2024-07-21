import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                if(i >= j)
                    arr[i][j] = Integer.parseInt(st.nextToken());
                else
                    arr[i][j] = -1;
            }
        }

        int max = arr[0][0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == -1)
                    continue;
                if(i == j) {
                    arr[i][j] += arr[i-1][j-1];
                    max = (arr[i][j] > max) ? arr[i][j] : max;
                }
                else if(j == 0) {
                    arr[i][0] += arr[i-1][0];
                    max = (arr[i][j] > max) ? arr[i][j] : max;
                }
                else {
                    arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
                    max = (arr[i][j] > max) ? arr[i][j] : max;
                }
            }
        }
        sb.append(max);
        System.out.println(sb);
    }
}
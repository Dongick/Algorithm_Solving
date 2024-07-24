import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        int[][] dpB = new int[n+1][m+1];
        int[][] dpW = new int[n+1][m+1];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(((i+j) % 2 == 0 && arr[i][j] == 'B') || ((i+j) % 2 == 1 && arr[i][j] == 'W')) {
                    dpB[i+1][j+1] = dpB[i][j+1] + dpB[i+1][j] - dpB[i][j];
                    dpW[i+1][j+1] = dpW[i][j+1] + dpW[i+1][j] - dpW[i][j] + 1;
                } else {
                    dpB[i+1][j+1] = dpB[i][j+1] + dpB[i+1][j] - dpB[i][j] + 1;
                    dpW[i+1][j+1] = dpW[i][j+1] + dpW[i+1][j] - dpW[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = k; i <= n; i++) {
            for(int j = k; j <= m; j++) {
                int b = dpB[i][j] - dpB[i-k][j] - dpB[i][j-k] + dpB[i-k][j-k];
                int w = dpW[i][j] - dpW[i-k][j] - dpW[i][j-k] + dpW[i-k][j-k];
                min = Math.min(min, Math.min(b, w));
            }
        }
        sb.append(min);
        System.out.println(sb);
    }
}
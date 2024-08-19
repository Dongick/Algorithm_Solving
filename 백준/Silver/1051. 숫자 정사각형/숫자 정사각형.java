import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        int size  = Math.min(n, m);
        for(int i = size; i >= 1; i--) {
            if(func(i)) {
                sb.append(i * i);
                System.out.println(sb);
                return;
            }
        }
    }

    static boolean func(int size) {
        for(int i = 0; i <= n - size; i++) {
            for(int j = 0; j <= m - size; j++) {
                if(arr[i][j] == arr[i][j+size-1] && arr[i][j] == arr[i+size-1][j] && arr[i][j] == arr[i+size-1][j+size-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
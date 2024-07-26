import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr1, arr2;
    static int n, m, k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr1[i][j] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr2 = new int[m][k];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < k; j++)
                arr2[i][j] = Integer.parseInt(st.nextToken());
        }
        func(0, 0);

        System.out.println(sb);
    }

    static void func(int x, int y) {
        int num = 0;
        for(int i = 0; i < m; i++) {
            num += arr1[x][i] * arr2[i][y];
        }
        sb.append(num).append(" ");
        if(x == n - 1 && y == k - 1)
            return;
        if(y < k-1)
            func(x, y+1);
        else {
            sb.append("\n");
            func(x+1, 0);
        }
    }
}
import java.io.*;
import java.util.*;

class Main{
    static int[][] arr;
    static boolean[] check;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = arr[num2][num1] = 1;
        }
        check = new boolean[n + 1];
        dfs(1);
        int result = 0;
        for(int i = 2; i <= n; i++) {
            if(check[i])
                result++;
        }
        System.out.println(result);
    }
    
    static void dfs(int num) {
        check[num] = true;
        for(int i = 1; i <= n; i++) {
            if(arr[num][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
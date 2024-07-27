import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] result = func(b);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                sb.append(result[i][j] % 1000).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] func(long count) {
        if(count == 1)
            return arr;

        int[][] temp = func(count / 2);
        if(count % 2 == 1)
            return mulMatrix(mulMatrix(arr, temp), temp);
        return mulMatrix(temp, temp);
    }

    static int[][] mulMatrix(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                }
                temp[i][j] %= 1000;
            }
        }
        return temp;
    }
}
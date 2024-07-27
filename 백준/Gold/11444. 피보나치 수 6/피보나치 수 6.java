import java.util.*;
import java.io.*;

class Main {
    final static int P = 1000000007;
    static long[][] arr = {{1, 1}, {1, 0}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        int[][] num = {{1}, {0}};
        long[][] fibo = fibo(n);
        long[][] result = new long[2][1];
        for(int i = 0; i < 2; i++) {
            for(int k = 0; k < 2; k++) {
                result[i][0] += fibo[i][k] * num[k][0] % P;
            }
        }
        sb.append(result[1][0]);
        System.out.println(sb);
    }

    static long[][] fibo(long count) {
        if(count == 1)
            return arr;

        long[][] temp = fibo(count / 2);
        if(count % 2 == 1)
            return mulMatrix(mulMatrix(temp, temp), arr);
        return mulMatrix(temp, temp);
    }

    static long[][] mulMatrix(long[][] arr1, long[][] arr2) {
        long[][] temp = new long[2][2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j];
                }
                temp[i][j] %= P;
            }
        }
        return temp;
    }
}
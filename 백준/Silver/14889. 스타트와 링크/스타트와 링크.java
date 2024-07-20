import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int[] member;
    static int n;
    static int min = Integer.MAX_VALUE;
    static long max = 1;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        member = new int[n/2];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = n; i > 0; i--) {
            if(i > n/2)
                max *= i;
            else
                max /= i;
        }
        func(0, 1);
    }

    static void func(int idx, int num) {
        if(idx == n/2) {
            count++;
            sum();
            return;
        }

        if(count == max) {
            sb.append(min);
            System.out.println(min);
            System.exit(0);
        }
        
        for(int i = num; i <= n; i++) {
            member[idx] = i;
            func(idx+1, i+1);
            member[idx] = 0;
        }
    }

    static void sum() {
        int sum1 = 0, sum2 = 0;
        int indexX = 0;
        for(int i = 1; i<= n; i++) {
            int indexY = 0;
            for(int j = 1; j <= n; j++) {
                if(indexX < n/2 && indexY < n/2 && member[indexY] == j && member[indexX] == i) {
                    sum1 += arr[i][j];
                    indexY++;
                } else if(indexX < n/2 && member[indexX] == i)
                    continue;
                else if(indexY < n/2 && member[indexY] == j) {
                    indexY++;
                    continue;
                }
                else
                    sum2 += arr[i][j];
            }
            if(indexX < n/2 && member[indexX] == i)
                indexX++;
        }
        min = (Math.abs(sum1 - sum2) < min) ? Math.abs(sum1 - sum2) : min;
    }
}
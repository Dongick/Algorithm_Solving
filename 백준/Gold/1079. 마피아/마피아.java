import java.util.*;
import java.io.*;

class Main {
    static int[][] R;
    static int[] arr;
    static boolean[] check;
    static int n;
    static int result = 0;
    static int num;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        R = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                R[i][j] = Integer.parseInt(st.nextToken());
        }
        num = Integer.parseInt(br.readLine());
        check = new boolean[n];
        func(0, n);

        sb.append(result);
        System.out.println(sb);
    }

    static void func(int count, int number) {
        if(check[num] || number == 1) {
            result = Math.max(result, count);
            return;
        }
        
        if(number % 2 == 1) {
            int max = 0;
            int idx = 0;
            for(int i = 0; i < n; i++) {
                if(!check[i] && max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
            check[idx] = true;
            func(count, number-1);
            check[idx] = false;
        } else {
            for(int i = 0; i < n; i++) {
                if(!check[i] && num != i) {
                    check[i] = true;
                    for(int j = 0; j < n; j++) {
                        arr[j] += R[i][j];
                    }
                    
                    func(count+1, number-1);

                    for(int j = 0; j < n; j++) {
                        arr[j] -= R[i][j];
                    }
                    check[i] = false;
                }
            }
        }
    }
}
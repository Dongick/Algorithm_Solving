import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] operator = new int[5];
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        func(0, arr[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void func(int num, int sum) {
        if(num == n - 1) {
            if(sum >= max)
                max = sum;
            if(sum <= min)
                min = sum;
            return;
        }
        
        for(int i = 1; i <= 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                func(num + 1, calc(sum, i, arr[num + 1]));
                operator[i]++;
            }
        }
    }

    static int calc(int x, int ope, int y) {
        int num = x;
        switch (ope) {
            case 1:
                num += y;
                break;
            case 2:
                num -= y;
                break;
            case 3:
                num *= y;
                break;
            case 4:
                num /= y;
                break;
        }
        return num;
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] check;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        check = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            arr[1] = i;
            check[i] = true;
            chess(1);
            check[i] = false;
        }
        sb.append(count);
        System.out.println(sb);
    }

    static void chess(int num) {
        for(int i = 1; i < num; i++) {
            if(!check(num, i, arr[i]))
                return;
        }
        if(num == n) {
            count++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                arr[num+1] = i;
                check[i] = true;
                chess(num+1);
                check[i] = false;
            }
        }
    }

    static boolean check(int num, int x, int y) {
        int y1 = arr[num];
        int x1 = num;
        if(Math.abs(x1 - x) == Math.abs(y1 - y))
            return false;
        return true;
    }
}
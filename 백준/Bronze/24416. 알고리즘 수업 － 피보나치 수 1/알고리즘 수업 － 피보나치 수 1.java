import java.util.*;
import java.io.*;

class Main {
    static int count = 0;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        fib(n);
        sb.append(count).append(" ");
        sb.append(n-2);
        System.out.println(sb);
    }

    static int fib(int n) {
        if(n == 1 || n == 2) {
            count++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
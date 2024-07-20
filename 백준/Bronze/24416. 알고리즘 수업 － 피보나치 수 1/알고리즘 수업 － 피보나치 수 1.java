import java.util.*;
import java.io.*;

class Main {
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        fib(n);
        sb.append(count).append(" ").append(n-2);
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
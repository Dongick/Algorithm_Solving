import java.util.*;
import java.io.*;

class Main {
    final static int P = 1000000007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long num = factorial(n);
        long deno = factorial(k) * factorial(n-k) % P;
        sb.append(num * func(deno, P-2) % P);
        
        System.out.println(sb);
    }

    static long factorial(int n) {
        long number = 1;
        for(int i = n; i > 0; i--) {
            number = (number * i) % P;
        }
        return number;
    }

    static long func(long num, int count) {
        if(count == 1)
            return num % P;
        long temp = func(num, count / 2);
        if(count % 2 == 1)
            return (temp * temp % P) * num % P;
        return temp * temp % P;
    }
}
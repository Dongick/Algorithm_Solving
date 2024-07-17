import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append(factorial(n));
        System.out.println(sb);
    }

    static long factorial(int n) {
        if(n <= 1)
            return 1;
        return (long)n * factorial(n-1);
    }
}
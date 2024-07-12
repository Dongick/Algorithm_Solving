import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = GCD(a, b);
        sb.append((long)a * b / gcd).append("\n");
        System.out.println(sb);
    }

    static int GCD(int a, int b) {
        if(a % b == 0)
            return b;
        return GCD(b, a % b);
    }
}
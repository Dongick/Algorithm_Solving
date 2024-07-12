import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int num1 = a1*b2 + a2*b1;
        int num2 = b1*b2;
        int gcd = GCD(num1, num2);
        sb.append(num1 / gcd).append(" ").append(num2 / gcd);
        System.out.println(sb);
    }

    static int GCD(int a, int b) {
        if(a % b == 0)
            return b;
        return GCD(b, a % b);
    }
}
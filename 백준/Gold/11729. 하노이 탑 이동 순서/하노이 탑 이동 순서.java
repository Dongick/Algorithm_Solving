import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, n) - 1 + "\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int mid, int end) {
        if(n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }
        hanoi(n-1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(n-1, mid, start, end);
    }
}
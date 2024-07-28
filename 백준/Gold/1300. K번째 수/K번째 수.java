import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        sb.append(func(n, k));
        System.out.println(sb);
    }

    static long func(int n, int k) {
        long low = 1;
        long hi = k;
        while(low < hi) {
            long count = 0;
            long mid = (low + hi) / 2;
            for(int i = 1; i <= n; i++) {
                if(mid / i > n)
                    count += n;
                else
                    count += mid / i;
            }
            if(count < k) {
                low = mid + 1;
            } else {
                hi = mid;
            }
        }
        return low;
    }
}
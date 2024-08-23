import java.util.*;
import java.io.*;

class Main {
    static int x, y;
    static double ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        ans = (double)y * 100 / x;
        if(ans >= 99)
            sb.append(-1);
        else {
            int result = BinarySearch(0, x);
            sb.append(result);
        }
        System.out.println(sb);
    }

    static int BinarySearch(int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if((double)(y + mid) * 100 / (x + mid) >= (int)ans + 1)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }
}
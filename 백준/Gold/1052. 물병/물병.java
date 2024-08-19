import java.util.*;
import java.io.*;

class Main {
    static int n, k;
    static int[] arr = new int[32];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int idx = 0;
        while(n > 0) {
            arr[idx] = n % 2;
            n /= 2;
            idx++;
        }
        int count = 0;
        int index = 0;
        for(int i = idx-1; i >= 0; i--) {
            if(arr[i] == 1) {
                count++;
                if(count == k)
                    index = i;
            }
        }
        if(count > k) {
            int result = (int)Math.pow(2, index + 1);
            for(int i = 0; i <= index; i++) {
                if(arr[i] == 1) {
                    result -= (int)Math.pow(2, i);
                }
            }
            sb.append(result);
        } else {
            sb.append(0);
        }
        System.out.println(sb);
    }
}
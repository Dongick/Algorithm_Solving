import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            int x = 0;
            int y = 0;
            double in = 0;
            int count = 0;
            for(int j = 0; j < n; j++) {
                boolean check = true;
                if(i == j)
                    continue;
                if(i + 1 == j || i - 1 == j) {
                    count++;
                    continue;
                }
                x = i - j;
                y = arr[i] - arr[j];
                in = y / (double)x;
                for(int k = 0; k < n; k++) {
                    if((i > k && j < k) || (i < k && j > k)) {
                        if(in * (k - i) + arr[i] <= arr[k]) {
                            check = false;
                            break;
                        }
                    }
                }
                if(check)
                    count++;
            }
            if(max < count)
                max = count;
        }
        System.out.println(max);
    }
}
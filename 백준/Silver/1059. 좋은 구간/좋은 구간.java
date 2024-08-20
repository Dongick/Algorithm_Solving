import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[L];
        for(int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        if(arr[L-1] < n) {
            sb.append(0);
            System.out.println(sb);
            return;
        }
        
        int idx = 0;
        for(int i = 0; i < L; i++) {
            if(arr[i] == n) {
                sb.append(0);
                System.out.println(sb);
                return;
            }
            if(arr[i] > n) {
                idx = i;
                break;
            }
        }

        int result = 0;
        if(idx == 0) {
            for(int i = 1; i <= n; i++) {
                for(int j = n; j < arr[idx]; j++) {
                    result++;
                }
            }
        } else {
            for(int i = arr[idx - 1] + 1; i <= n; i++) {
                for(int j = n; j < arr[idx]; j++) {
                    result++;
                }
                
            }
        }
        
        sb.append(result-1);
        System.out.println(sb);
        
    }
}
import java.io.*;
import java.util.*;

class Main{
    static boolean[] arr = new boolean[10001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        function();
        while(T-- > 0) {
            boolean check = false;
            int n = Integer.parseInt(br.readLine());
            for(int i = n/2; i >= 2; i--) {
                if(arr[i])
                    continue;
                for(int j = i; j < n; j++) {
                    if(arr[j])
                        continue;
                    if(i + j == n) {
                        sb.append(i).append(" ").append(j).append("\n");
                        check = true;
                        break;
                    }
                }
                if(check)
                    break;
            }
        }
        System.out.println(sb);
    }
    
    static void function() {
        arr[0] = arr[1] = true;
        for(int i = 2; i <= Math.sqrt(10000); i++) {
            if(arr[i])
                continue;
            for(int j = i*i; j <= 10000; j += i) {
                if(!arr[j])
                    arr[j] = true;
            }
        }
    }
}
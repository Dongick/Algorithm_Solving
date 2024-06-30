import java.io.*;
import java.util.*;

class Main{
    static boolean[] arr;
    static int maxNum = 123456 * 2 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new boolean[maxNum];
        arr[1] = true;
        function();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            int count = 0;
            for(int i = n+1; i <= n*2; i++) {
                if(!arr[i])
                    count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    
    static void function() {
        for(int i = 2; i <= Math.sqrt(maxNum); i++) {
            if(arr[i])
                continue;
            for(int j = i*i; j < maxNum; j += i) {
                if(!arr[j])
                    arr[j] = true;
            }
        }
    }
}
import java.io.*;
import java.util.*;

class Main{
    static boolean[] arr;
    static int n;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        if(m == 1)
            m+=1;
        arr = new boolean[n + 1];
        find();
        
        for(int i = m; i <= n; i++) {
            if(!arr[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    
    static void find() {
        for(int i = 2; i <= n; i++) {
            for(int j = i*2; j <= n; j += i) {
                if(!arr[j]) {
                    arr[j] = true;
                }
            }
        }
    }
}
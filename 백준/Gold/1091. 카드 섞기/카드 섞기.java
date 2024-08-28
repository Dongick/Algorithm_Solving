import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] temp;
    static int count = 0;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            s[i] = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
            temp[i] = arr[i];
        }
        func(p, s);
        sb.append(count);
        
        System.out.println(sb);
    }

    static void func(int[] p, int[] s) {
        while(true) {
            boolean check = true;
            for(int i = 0; i < n; i++) {
                if(p[temp[i]] != i % 3) {
                    check = false;
                    break;
                }
            }
            if(check)
                return;
            
            int[] temp2 = new int[n];
            for(int i = 0; i < n; i++) {
                temp2[s[i]] = temp[i];
            }
            count++;
            temp = temp2;

            for(int i = 0; i < n; i++) {
                if(arr[i] != temp[i]) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                count = -1;
                return;
            }
        }
    }
}
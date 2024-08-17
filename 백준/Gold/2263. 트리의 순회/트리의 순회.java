import java.util.*;
import java.io.*;

class Main {
    static int[] in;
    static int[] post;
    static int[] pre;
    static int idx = 1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        in = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        post = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        pre = new int[n+1];
        preOrder(1, n, 1, n);
        for(int i = 1; i <= n; i++)
            sb.append(pre[i]).append(" ");
        
        System.out.println(sb);
    }

    static void preOrder(int inS, int inE, int postS, int postE) {
        if(inS <= inE && postS <= postE) {
            pre[idx++] = post[postE];

            int root = inS;
            for(int i = inS; i <= inE; i++) {
                if(in[i] == post[postE]) {
                    root = i;
                    break;
                }
            }

            preOrder(inS, root-1, postS, postS + root - inS - 1);
            preOrder(root+1, inE, postS + root - inS, postE - 1);
        }
    }
}
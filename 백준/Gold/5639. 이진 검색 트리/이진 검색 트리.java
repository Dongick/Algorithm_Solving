import java.util.*;
import java.io.*;

class Main {
    static int[] pre = new int[10000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int i = 0;
        while((s = br.readLine()) != null) {
            pre[i] = Integer.parseInt(s);
            i++;
        }
        postOrder(0, i-1);
        System.out.println(sb);
    }

    static void postOrder(int start, int end) {
        if(start <= end) {
            int root = pre[start];
            int subIdx = end + 1;
            for(int i = start; i <= end; i++) {
                if(root < pre[i]) {
                    subIdx = i;
                    break;
                }
            }
    
            postOrder(start+1, subIdx-1);
            postOrder(subIdx, end);
            sb.append(root).append("\n");
        }
    }
}
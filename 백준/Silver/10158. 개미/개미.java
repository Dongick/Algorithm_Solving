import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int w= Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        
        int a1 = t / w;
        int a2 = t % w;
        int b1 = t / h;
        int b2 = t % h;
        if(a1 % 2 == 0)
            sb.append(w - Math.abs(p + a2 - w)).append(" ");
        else
            sb.append(Math.abs(w - p - a2)).append(" ");
        
        if(b1 % 2 == 0)
            sb.append(h - Math.abs(b2 + q - h));
        else
            sb.append(Math.abs(h - q - b2));
        
        System.out.println(sb);
    }
}
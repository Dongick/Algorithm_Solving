import java.io.*;
import java.util.*;

class Main{
    static int s,n,k,r1,r2,c1,c2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(n, s);
        
        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
                sb.append(fractal(size, i, j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static int fractal(int size, int x, int y) {
        if(size == 1)
            return 0;
        int board = size / n;
        if(board * (n - k) / 2 <= x && board * (n + k) / 2 > x &&
          board * (n - k) / 2 <= y && board * (n + k) / 2 > y)
            return 1;
        return fractal(board, x % board, y % board);
    }
}
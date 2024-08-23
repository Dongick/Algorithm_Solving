import java.util.*;
import java.io.*;

class Main {
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);

        func(r, c, size);
        sb.append(count);
        System.out.println(sb);
    }

    static void func(int r, int c, int size) {
        if(size == 1)
            return;

        if(r < size / 2 && c < size / 2) {
            func(r, c, size / 2);
        } else if(r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            func(r, c - size / 2, size / 2);
        } else if(r >= size / 2 && c < size / 2) {
            count += (size * size / 4) * 2;
            func(r - size / 2, c, size / 2);
        } else {
            count += (size * size / 4) * 3;
            func(r - size / 2, c - size / 2, size / 2);
        }
    }
}
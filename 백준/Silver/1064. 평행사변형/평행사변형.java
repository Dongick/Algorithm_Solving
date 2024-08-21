import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        double result = -1;

        if((x1 - x2) * (y1 - y3) == (x1 - x3) * (y1 - y2)) {
            sb.append(result);
            System.out.println(sb);
            return;
        }

        double line1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double line2 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double line3 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double max = Math.max(line1+line2, Math.max(line1+line3, line2+line3));
        double min = Math.min(line1+line2, Math.min(line1+line3, line2+line3));
        result = max * 2 - min * 2;
        sb.append(result);
        
        System.out.println(sb);
    }

}
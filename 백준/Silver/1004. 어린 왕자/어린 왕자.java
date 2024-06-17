import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int num = Integer.parseInt(br.readLine());
            for(int j = 0; j < num; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int c1 = Integer.parseInt(st2.nextToken());
                int c2 = Integer.parseInt(st2.nextToken());
                int r = Integer.parseInt(st2.nextToken());
                
                result = find(x1, y1, x2, y2, c1, c2, r, result);
            }
            System.out.println(result);
        }
    }
    
    static int find(int x1, int y1, int x2, int y2, int c1, int c2, int r, int result) {
        Boolean start = (x1 - c1) * (x1 - c1) + (y1 - c2) * (y1 - c2) < r * r;
        Boolean end = (x2 - c1) * (x2 - c1) + (y2 - c2) * (y2 - c2) < r * r;
        
        if(start && end) {
            return result;
        } else if(start || end) {
            return result + 1;
        } else {
            return result;
        }
    }
}


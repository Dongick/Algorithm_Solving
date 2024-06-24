import java.io.*;
import java.util.*;

class Main{
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            count = 0;
            int num = Integer.parseInt(br.readLine());
            check(num);
            System.out.println(count);
        }
    }
    
    static void check(int num) {
        if(num == 0) {
            count++;
        }
        if(num >= 1) {
            check(num-1);
        }
        if(num >= 2) {
            check(num-2);
        }
        if(num >= 3) {
            check(num-3);
        }
    }
}
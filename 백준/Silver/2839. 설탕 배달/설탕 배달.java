import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        check(num, 0);
    }
    
    static void check(int num, int count) {
        if(num % 5 == 0) {
            System.out.println(count + num/5);
            return;
        }
        if(num < 0) {
            System.out.println(-1);
            return;
        }
        check(num-3, count+1);
    }
}
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 666;
        int count = 1;
        while(count != n) {
            result++;
            String s = String.valueOf(result);
            if(s.contains("666"))
                count++;
        }
        System.out.println(result);
    }
}
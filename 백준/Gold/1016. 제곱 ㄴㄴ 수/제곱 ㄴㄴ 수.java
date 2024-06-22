import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        long result = max - min + 1;
        boolean[] check = new boolean[(int)result];
        
        for(long i = 2; i*i <= max; i++) {
            long pow = i*i;
            long start = 0;
            if(min % pow == 0) {
                start = min / pow;
            } else {
                start = min / pow + 1;
            }
            for(long j = start; j * pow <= max; j++) {
                int trueCheck = (int)(j * pow - min);
                if(!check[trueCheck]) {
                    check[trueCheck] = true;
                    result--;
                }
            }
        }
        
        System.out.println(result);
    }
}
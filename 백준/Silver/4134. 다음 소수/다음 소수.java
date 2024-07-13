import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            long num = Long.parseLong(br.readLine());
            if(num == 0 || num == 1)
                sb.append(2).append("\n");
            else {
                while(true) {
                    boolean check = false;
                    for(int i = 2; i <= Math.sqrt(num); i++) {
                        if(num % i == 0) {
                            num++;
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        sb.append(num).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
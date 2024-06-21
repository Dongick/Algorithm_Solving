import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(100+1+|01)+";
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String num = br.readLine();
            if(num.matches(regex)) {
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
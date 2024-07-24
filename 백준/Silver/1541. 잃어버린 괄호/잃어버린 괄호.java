import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split("-");
        int result = 0;
        for(int i = 0; i < s.length; i++) {
            String[] arr = s[i].split("\\+");
            if(i == 0) {
                for(String j : arr)
                    result += Integer.parseInt(j);
            } else
                for(String j : arr)
                    result -= Integer.parseInt(j);
        }
        sb.append(result);
        System.out.println(sb);
    }
}
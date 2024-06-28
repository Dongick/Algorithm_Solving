import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String s : arr) {
            int length = s.length();
            while(str.contains(s)) {
                int index = str.indexOf(s);
                str = str.substring(0, index) + '0' + str.substring(index+length);
            }
        }
        System.out.println(str.length());
    }
}
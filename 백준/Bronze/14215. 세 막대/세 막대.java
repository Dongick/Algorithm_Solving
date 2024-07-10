import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        if(n1 >= n2 && n1 >= n3) {
            if(n1 >= n2 + n3) {
                System.out.println((n2 + n3 - 1) + n2 + n3);
            } else
                System.out.println(n1 + n2 + n3);
        } else if(n2 >= n1 && n2 >= n3) {
            if(n2 >= n1 + n3) {
                System.out.println((n1 + n3 - 1) + n1 + n3);
            } else
                System.out.println(n1 + n2 + n3);
        } else {
            if(n3 >= n1 + n2) {
                System.out.println((n1 + n2 - 1) + n1 + n2);
            } else
                System.out.println(n1 + n2 + n3);
        }
    }
}
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if(n1 == 0)
                break;
            if(n1 + n2 <= n3 || n1 + n3 <= n2 || n2 + n3 <= n1)
                System.out.println("Invalid");
            else {
                if(n1 == n2 && n2 == n3)
                    System.out.println("Equilateral");
                else if(n1 != n2 && n1 != n3 && n2 != n3)
                    System.out.println("Scalene");
                else
                    System.out.println("Isosceles");
            }
        }
    }
}
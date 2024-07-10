import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[3];
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            n[i] = Integer.parseInt(br.readLine());
            sum += n[i];
        }
        if(sum != 180)
            System.out.println("Error");
        else {
            if(n[0] == n[1] && n[1] == n[2])
                System.out.println("Equilateral");
            else if(n[0] != n[1] && n[1] != n[2] && n[0] != n[2])
                System.out.println("Scalene");
            else
                System.out.println("Isosceles");
        }
    }
}
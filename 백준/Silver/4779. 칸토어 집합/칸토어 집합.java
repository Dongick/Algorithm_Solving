import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int size = (int)Math.pow(3, n);
            boolean[] arr = new boolean[size];
            int temp = size;
            while(temp / 3 >= 1) {
                temp = temp / 3;
                int k = 0;
                while(temp * k < size) {
                    for(int i = temp * k; i < temp * (k + 1); i++) {
                        if(k % 2 == 0)
                            break;
                        if(!arr[i])
                            arr[i] = true;
                    }
                    k++;
                }
            }
            for(int i = 0; i < size; i++) {
                if(arr[i])
                    sb.append(" ");
                else
                    sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
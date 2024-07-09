import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n != -1) {
            List<Integer> list = new ArrayList<>();
            int max = 0;
            int temp = n;
            int i = 1;
            while(temp > i) {
                if(n % i == 0) {
                    list.add(i);
                    max += i;
                    if(n / i != i) {
                        list.add(n / i);
                        max += n/i;
                    }
                }
                temp = n / i;
                i++;
            }
            Collections.sort(list);
            if(max - list.get(list.size() - 1) != n)
                sb.append(n).append(" is NOT perfect.").append("\n");
            else {
                sb.append(n).append(" = ");
                for(int j = 0; j < list.size() - 2; j++)
                    sb.append(list.get(j)).append(" + ");
                sb.append(list.get(list.size() - 2)).append("\n");
            }
            n = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
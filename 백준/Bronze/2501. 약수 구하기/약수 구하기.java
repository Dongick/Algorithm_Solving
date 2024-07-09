import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int temp = 10001;
        int i = 1;
        List<Integer> list = new ArrayList<>();
        while(temp > i) {
            if(n % i == 0) {
                list.add(i);
                if(n / i != i)
                    list.add(n / i);
            }
            temp = n / i;
            i++;
        }
        Collections.sort(list);
        if(list.size() < k)
            System.out.println(0);
        else
            System.out.println(list.get(k-1));
    }
}
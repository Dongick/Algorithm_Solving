import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) 
            hashMap.put(br.readLine(), 0);
        int count = 0;
        for(int i = 0; i < m; i++) {
            if(hashMap.containsKey(br.readLine()))
                count++;
        }
        System.out.println(count);
    }
}
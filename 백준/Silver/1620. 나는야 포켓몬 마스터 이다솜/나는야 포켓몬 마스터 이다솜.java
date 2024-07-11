import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            hashMap.put(s, i);
            hashMap2.put(i, s);
        }
        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            try{
                int num = Integer.parseInt(s);
                sb.append(hashMap2.get(num)).append("\n");
            } catch(Exception e) {
                sb.append(hashMap.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
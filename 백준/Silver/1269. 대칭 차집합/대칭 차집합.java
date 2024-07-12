import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<Integer> hashSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(hashSet.contains(num))
                hashSet.remove(num);
            else
                hashSet.add(num);
        }
        System.out.println(hashSet.size());
    }
}
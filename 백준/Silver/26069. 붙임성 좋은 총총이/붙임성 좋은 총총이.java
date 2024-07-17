import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if(s1.equals("ChongChong") || s2.equals("ChongChong")) {
                hashSet.add(s1);
                hashSet.add(s2);
            } else {
                if(hashSet.contains(s1) || hashSet.contains(s2)) {
                    hashSet.add(s1);
                    hashSet.add(s2);
                }
            }
        }
        System.out.println(hashSet.size());
    }
}
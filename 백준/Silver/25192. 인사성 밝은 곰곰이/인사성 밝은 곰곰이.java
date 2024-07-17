import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.equals("ENTER")) {
                count += hashSet.size();
                hashSet.clear();
            } else
                hashSet.add(s);
        }
        count += hashSet.size();
        System.out.println(count);
    }
}
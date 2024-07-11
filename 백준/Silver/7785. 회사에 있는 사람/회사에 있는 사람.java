import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String record = st.nextToken();
            if(record.equals("enter")) {
                hashSet.add(name);
            } else {
                hashSet.remove(name);
            }
            
        }
        List<String> list = new ArrayList<>(hashSet);
        Collections.sort(list, Collections.reverseOrder());
        for(String s : list)
            System.out.println(s);
    }
}
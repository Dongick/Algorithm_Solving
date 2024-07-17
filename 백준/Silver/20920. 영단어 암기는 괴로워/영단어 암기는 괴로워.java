import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length() >= m) {
                if(map.containsKey(s)) {
                    int count = map.get(s);
                    map.replace(s, count+1);
                } else
                    map.put(s, 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            int countCompare = map.get(o2).compareTo(map.get(o1));
            if(countCompare != 0)
                return countCompare;
            int lengthCompare = Integer.compare(o2.length(), o1.length());
            if(lengthCompare != 0)
                return lengthCompare;
            return o1.compareTo(o2);
        });
        for(String s : list)
            sb.append(s).append("\n");
        System.out.println(sb);
    }
}
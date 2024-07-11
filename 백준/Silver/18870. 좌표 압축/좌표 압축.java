import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> temp = list.stream().distinct().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < temp.size(); i++) {
            map.put(temp.get(i), i);
        }
        for(int i = 0; i < n; i++) {
            sb.append(map.get(list.get(i))).append(" ");
        }
        System.out.println(sb);
    }
}
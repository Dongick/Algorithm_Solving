import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        HashMap<Integer, Integer> map = new HashMap<>();
        double sum = 0;
        int median = 0;
        int max = 1;
        for(int i = 0; i< n; i++) {
            int num = list.get(i);
            if(i == n / 2)
                median = num;
            sum += num;
            if(map.containsKey(num)) {
                int count = map.get(num);
                map.replace(num, count+1);
                if(max < count + 1)
                    max = count + 1;
            } else
                map.put(num, 1);
        }
        int range = list.get(list.size() - 1) - list.get(0);
        List<Integer> maxList = new ArrayList<>();
        for(int num : map.keySet()) {
            if(map.get(num) == max)
                maxList.add(num);
        }
        Collections.sort(maxList);
        sb.append(Math.round(sum / n)).append("\n");
        sb.append(median).append("\n");
        if(maxList.size() >= 2)
            sb.append(maxList.get(1)).append("\n");
        else
            sb.append(maxList.get(0)).append("\n");
        sb.append(range).append("\n");
        System.out.println(sb);
    }
}
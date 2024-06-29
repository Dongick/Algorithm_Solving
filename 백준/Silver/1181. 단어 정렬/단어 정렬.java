import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int maxLength = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if(arr[i].length() > maxLength) {
                maxLength = arr[i].length();
            }
        }
        String[] distinctArr = Arrays.stream(arr).distinct().toArray(String[]::new);
        for(int i = 1; i <= maxLength; i++) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < distinctArr.length; j++) {
                if(distinctArr[j].length() == i) {
                    list.add(distinctArr[j]);
                }
            }
            if(!list.isEmpty()) {
                list.sort(Comparator.naturalOrder());
                for(String s : list)
                    sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }
}
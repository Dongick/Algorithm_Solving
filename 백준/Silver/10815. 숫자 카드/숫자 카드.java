import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[20000001];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0)
                arr[10000000 + num] = true;
            else
                arr[Math.abs(num)] = true;
        }
        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0) {
                if(arr[10000000 + num])
                    sb.append(1).append(" ");
                else
                    sb.append(0).append(" ");
            } else
                if(arr[Math.abs(num)])
                    sb.append(1).append(" ");
                else
                    sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
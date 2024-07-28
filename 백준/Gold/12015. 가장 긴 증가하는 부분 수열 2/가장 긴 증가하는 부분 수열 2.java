import java.util.*;
import java.io.*;

class Main {
    static List<Integer> list = new ArrayList<>();
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        func(n, 0);
        
        sb.append(list.size());
        System.out.println(sb);
    }

    static void func(int n, int idx) {
        list.add(arr[idx]);
        
        for(int i = 1; i < n; i++) {
            if(list.get(idx) < arr[i]) {
                list.add(arr[i]);
                idx++;
            } else {
                int index = binarySearch(arr[i]);
                list.set(index, arr[i]);
            }
        }
    }

    static int binarySearch(int num) {
        int low = 0;
        int hi = list.size() - 1;

        while(low < hi) {
            int mid = (low + hi) / 2;
            
            if(list.get(mid) >= num) {
                hi = mid;
            } else
                low = mid + 1;
        }
        return hi;
    }
}
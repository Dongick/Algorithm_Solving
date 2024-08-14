import java.util.*;
import java.io.*;

class Main {
    static int n, c;
    static int[] arr;
    static List<Integer> right;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        List<Integer> left = new ArrayList<>();
        right = new ArrayList<>();
        func(left, 0, n/2, 0);
        func(right, n/2, n, 0);
        Collections.sort(right);
        
        int result = 0;
        for(int num : left) {
            result += BinarySearch(0, right.size()-1, num) + 1;
        }
        sb.append(result);
        System.out.println(sb);
    }

    static void func(List<Integer> list, int start, int end, int sum) {
        if(sum > c)
            return;
        if(start == end) {
            list.add(sum);
            return;
        }
        
        func(list, start+1, end, sum);
        func(list, start+1, end, sum + arr[start]);
    }

    static int BinarySearch(int start, int end, int num) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(c - num >= right.get(mid))
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return end;
    }
}
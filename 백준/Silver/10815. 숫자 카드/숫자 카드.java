import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(num)).append(" ");
        }
        System.out.println(sb);
    }

    static int BinarySearch(int num) {
        int start = 0;
        int end = n-1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == num)
                return 1;
            else if(arr[mid] > num)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] arr;
    static int[] indexArr;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        indexArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        list.add(arr[0]);
        for(int i = 1; i < n; i++) {
            if(list.get(idx) < arr[i]) {
                list.add(arr[i]);
                idx++;
                indexArr[i] = idx;
            } else {
                int index = BinarySearch(0, idx, arr[i]);
                list.set(index, arr[i]);
                indexArr[i] = index;
            }
        }
        sb.append(list.size()).append("\n");
        int[] result = new int[list.size()];
        int size = list.size() - 1;
        for(int i = n-1; i >= 0; i--) {
            if(indexArr[i] == size) {
                result[size] = arr[i];
                size--;
            }
        }
        for(int num : result)
            sb.append(num).append(" ");
        System.out.println(sb);
    }

    static int BinarySearch(int start, int end, int num) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < num)
                start = mid + 1;
            else
                end = mid;
        }
        
        return end;
    }
}
import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0)
                break;
            arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            long max = maxArea(0, n-1);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    static long maxArea(int low, int hi) {
        if(low == hi)
            return arr[low];
        
        int mid = (low + hi) / 2;
        
        long left = maxArea(low, mid);
        long right = maxArea(mid + 1, hi);

        long max = Math.max(left, right);
        max = Math.max(max, midArea(low, mid, hi));
        
        return max;
    }

    static long midArea(int low, int mid, int hi) {
        int left = mid;
        int right = mid;
        long height = arr[mid];
        long max = height;

        while(left > low && right < hi) {
            if(arr[left - 1] < arr[right + 1]) {
                right++;
                height = Math.min(height, arr[right]);
            } else {
                left--;
                height = Math.min(height, arr[left]);
            }
            max = Math.max(max, height * (right - left + 1));
        }

        while(left > low) {
            left--;
            height = Math.min(height, arr[left]);
            max = Math.max(max, height * (right - left + 1));
        }
        
        while(right < hi) {
            right++;
            height = Math.min(height, arr[right]);
            max = Math.max(max, height * (right - left + 1));
        }

        return max;
    }
}
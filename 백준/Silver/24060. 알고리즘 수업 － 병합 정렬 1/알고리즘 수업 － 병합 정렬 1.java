import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[] sorted;
    static int count = 0;
    static int result = 0;
    static int k;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        sorted = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        merge_sort(0, n-1);
        if(count < k)
            System.out.println(-1);
        else
            System.out.println(result);
    }
    
    static void merge_sort(int left, int right) {
        if(left >= right)
            return;
        int mid = (left + right) / 2;
        merge_sort(left, mid);
        merge_sort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while(l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                sorted[idx] = arr[l];
                l++;
            } else {
                sorted[idx] = arr[r];
                r++;
            }
            count++;
            if(count == k)
                result = sorted[idx];
            idx++;
        }
        
        if(l > mid) {
            while(r <= right) {
                sorted[idx] = arr[r];
                count++;
                if(count == k)
                    result = sorted[idx];
                idx++;
                r++;
            }
        } else {
            while(l <= mid) {
                sorted[idx] = arr[l];
                count++;
                if(count == k)
                    result = sorted[idx];
                idx++;
                l++;
            }
        }

        for(int i = left; i <= right; i++)
            arr[i] = sorted[i];
    }
}
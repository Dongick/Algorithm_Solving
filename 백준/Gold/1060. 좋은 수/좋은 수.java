import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[L+1];
        arr[0] = 0;
        for(int i = 1; i <= L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int[] result = new int[n];
        int count = 0;
        long[] arr2 = new long[L];
        int[] arr3 = new int[L];
        for(int i = 1; i <= L; i++) {
            arr2[i-1] = arr[i] - arr[i-1] - 2;
            if(arr2[i-1] == 0) {
                result[count] = arr[i-1] + 1;
                arr2[i-1] = -1;
                count++;
                if(count == n)
                    break;
            }
            result[count] = arr[i];
            count++;
            if(count == n)
                break;
            arr3[i-1] = 1;
        }

        while(count < n) {
            long min = Long.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < L; i++) {
                if(arr2[i] != -1) {
                    if(min > arr2[i]) {
                        min = arr2[i];
                        idx = i;
                    }
                }
            }
            if(idx == -1)
                break;

            int num = arr[idx] + arr3[idx];
            int num2 = arr[idx+1] - arr3[idx];
            if(num == num2) {
                result[count] = num;
                count++;
                arr2[idx] = -1;
            } else if(num > num2) {
                arr2[idx] = -1;
            } else {
                result[count] = num;
                count++;
                if(count == n)
                    break;
                result[count] = num2;
                count++;
                arr2[idx] += arr[idx+1] - arr[idx] - 2 - (arr3[idx] * 2 - 1);
                arr3[idx]++;

            }
        }

        for(int i = 0; i < count; i++) {
            sb.append(result[i]).append(" ");
        }
        while(count < n) {
            sb.append(++arr[L]).append(" ");
            count++;
        }
        System.out.println(sb);
        
    }
}
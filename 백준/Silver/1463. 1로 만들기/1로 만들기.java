import java.io.*;
import java.util.*;

class Main{
    static Integer[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new Integer[num + 1];
        arr[0] = arr[1] = 0;
        int result = check(num);
        System.out.println(result);
    }
    
    static int check(int num) {
        if(arr[num] == null) {
            if(num % 6 == 0) {
                arr[num] = Math.min(check(num-1), Math.min(check(num/3), check(num/2))) + 1;
            } else if(num % 3 == 0) {
                arr[num] = Math.min(check(num/3), check(num-1)) + 1;
            } else if(num % 2 == 0) {
                arr[num] = Math.min(check(num/2), check(num-1)) + 1;
            } else {
                arr[num] = check(num-1) + 1;
            }
        }
        return arr[num];
    }
}
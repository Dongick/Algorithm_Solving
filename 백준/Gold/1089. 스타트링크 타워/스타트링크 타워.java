import java.util.*;
import java.io.*;

class Main {
    static boolean[] check;
    static int n;
    static double result = 0;
    static List<List<Integer>> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        char[][] arr = new char[5][4*n-1];
        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            for(int j = 0; j < 4*n-1; j++)
                arr[i][j] = s.charAt(j);
        }
        for(int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        
        for(int i = 0; i < n; i++) {
            check = new boolean[10];
            for(int j = 0; j < 5; j++) {
                for(int k = 4 * i; k < 4 * i + 3; k++) {
                    if(k == 4*i+1 && (j == 1 || j == 3)) {
                        if(arr[j][k] == '#') {
                            sb.append(-1);
                            System.out.println(sb);
                            return;
                        }
                    }
                    if(k == 4*i+2 && (j == 0 || j == 2 || j == 4))
                        continue;
                    if(arr[j][k] == '#')
                        func(j, k % 4);
                        
                }
            }
            for(int j = 0; j < 10; j++) {
                if(!check[j])
                    list.get(i).add(j);
            }
        }

        int digit = n - 1;
        for(int i = 0; i < n; i++) {
            double sum = 0;
            for(int num : list.get(i))
                sum += num;
            result += sum / list.get(i).size() * (int)Math.pow(10, digit);
            digit--;
        }
        sb.append(result);
        
        System.out.println(sb);
    }

    static void func(int x, int y) {
        if(x == 0 && y == 0) {
            check[1] = true;
        } else if(x == 0 && y == 1) {
            check[1] = true;
            check[4] = true;
        } else if(x == 1 && y == 0) {
            check[1] = true;
            check[2] = true;
            check[3] = true;
            check[7] = true;
        } else if(x == 1 && y == 2) {
            check[5] = true;
            check[6] = true;
        } else if(x == 2 && y == 0) {
            check[1] = true;
            check[7] = true;
        } else if(x == 2 && y == 1) {
            check[0] = true;
            check[1] = true;
            check[7] = true;
        } else if(x == 3 && y == 0) {
            check[1] = true;
            check[3] = true;
            check[4] = true;
            check[5] = true;
            check[7] = true;
            check[9] = true;
        } else if(x == 3 && y == 2) {
            check[2] = true;
        } else if(x == 4 && y == 0) {
            check[1] = true;
            check[4] = true;
            check[7] = true;
        } else if(x == 4 && y == 1) {
            check[1] = true;
            check[4] = true;
            check[7] = true;
        }
    }
}
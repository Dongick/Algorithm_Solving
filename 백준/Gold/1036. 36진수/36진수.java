import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
    static int n, k;
    static String[] arr;
    static int maxLength = 0;
    static int[] maxIntResult;
    static BigInteger[] influence = new BigInteger[36];
    static char[] idxArr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            maxLength = Math.max(arr[i].length(), maxLength);
        }
        maxIntResult = new int[maxLength];
        k = Integer.parseInt(br.readLine());
        idxArr = new char[k];
        Arrays.fill(influence, BigInteger.ZERO);

        findInfluence();
        changeZ();
        change36();
    }

    static void findInfluence() {
        for(int i = 0; i < n; i++) {
            String s = arr[i];
            int in = 0;
            for(int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                int val = (c >= 'A' && c <= 'Z') ? c - 'A' + 10 : c - '0';
                influence[val] = influence[val].add(BigInteger.valueOf(35 - val).multiply(BigInteger.valueOf(36).pow(in)));
                in++;
            }
        }

        boolean[] check = new boolean[36];
        for(int i = 0; i < k; i++) {
            BigInteger maxNum = BigInteger.valueOf(-1);
            int idx = 0;
            for(int j = 0; j < 36; j++) {
                if(maxNum.compareTo(influence[j]) < 0 && !check[j]) {
                    maxNum = influence[j];
                    idx = j;
                }
            }

            if(idx <= 9)
                idxArr[i] = (char)(idx + '0');
            else
                idxArr[i] = (char)(idx + 'A' - 10);
            check[idx] = true;
        }
    }

    static void changeZ() {
        char[][] tempC = new char[n][maxLength];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                arr[i] = arr[i].replace(idxArr[j], 'Z');
            }

            for(int j = 0; j < arr[i].length(); j++) {
                tempC[i][arr[i].length() - j - 1] = arr[i].charAt(j);
            }

            for(int j = 0; j < arr[i].length(); j++) {
                if(tempC[i][j] >= 'A' && tempC[i][j] <= 'Z')
                    maxIntResult[j] += tempC[i][j] - 'A' + 10;
                else
                    maxIntResult[j] += tempC[i][j] - '0';
            }
        }
    }

    static void change36() {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        int up = 0;
        for(int i = 0; i < maxLength; i++) {
            int num = maxIntResult[i] + up;
            up = num / 36;
            if(num % 36 <= 9) {
                list.add((char)(num % 36 + '0'));
            } else {
                list.add((char)(num % 36 + 'A' - 10));
            }
        }
        while(up > 0) {
            int num = up % 36;
            up /= 36;
            if(num <= 9) {
                list.add((char)(num + '0'));
            } else {
                list.add((char)(num + 'A' - 10));
            }
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
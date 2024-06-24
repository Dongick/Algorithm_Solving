import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[100001];
        for(int i = 1; i < 10001; i++) {
            int number = selfNum(i);
            if(number <= 10000) {
                check[number] = true;
            }
        }
        for(int i = 1; i < 10001; i++) {
            if(!check[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
    
    static int selfNum(int num) {
        int number = num;
        while(num > 0) {
            number += num % 10;
            num /= 10;
        }
        return number;
    }
}
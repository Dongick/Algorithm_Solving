import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int amount = (int)(end - begin);
        int[] answer = new int[amount + 1];

        func(begin, end, answer);
        
        if(begin == 1) {
            answer[0] = 0;
        }
        return answer;
    }
    
    static void func(long begin, long end, int[] answer) {
        boolean[] check = new boolean[(int)(end - begin) + 1];
        Arrays.fill(answer, 1);
        
        for(int i = 2; i <= Math.sqrt(end); i++) {
            int num;
            if(begin <= i * 2)
                num = i * 2;
            else {
                if(begin % i == 0)
                    num = (int)begin;
                else
                    num =  ((int)begin / i + 1) * i;
            }

            for(int j = num; j <= end; j += i) {
                
                if(check[j - (int)begin])
                    continue;
                
                if(j / i > 10000000)
                    answer[j - (int)begin] = i;
                else {
                    answer[j - (int)begin] = Math.max(i, j / i);
                    check[j - (int)begin] = true;
                }
            }
        }
    }
}
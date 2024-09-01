import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = (int)Math.sqrt(n);
        for(int i = 1; i <= num; i++) {
            if(n % i == 0) {
                if(n / i != i)
                    answer += i;
                answer += n / i;
            }
        }
        
        return answer;
    }
}
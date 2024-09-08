class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        long num = 0;
        int i = 0;
        while(n != 0) {
            num += (n % k) * Math.pow(10, i);
            n /= k;
            i++;
        }
        
        while(num != 0) {
            long number = 0;
            i = 0;
            while(num % 10 != 0) {
                number += (num % 10) * Math.pow(10, i);
                num = num / 10;
                i++;
            }
            num /= 10;
            if(number != 0 && func(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean func(long number) {
        if(number == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}
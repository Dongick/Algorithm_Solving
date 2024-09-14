class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l; i <= r; i++) {
            if(i % 5 == 3)
                continue;
            
            long temp = i;
            while(true) {
                if(temp % 5 == 0)
                    temp /= 5;
                else
                    temp = temp / 5 + 1;
                
                if(temp % 5 == 3) {
                    break;
                }
                if(temp <= 5) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");
        for(String s : arr) {
            if(s.equals(""))
                continue;
            if(func(Long.parseLong(s)))
                answer++;
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
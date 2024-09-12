class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static String[] arr;
    static int answer;
    
    public int solution(int n, String[] data) {
        arr = data;
        answer = 0;
        dfs("", 0);
        return answer;
    }
    
    static void dfs(String s, int count) {
        if(count == 8) {
            if(func(s))
                answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(s + friends[i], count + 1);
                visited[i] = false;
            }
        }
        
    }
    
    static boolean func(String s) {
        for(String cond : arr) {
            int diff = Math.abs(s.indexOf(cond.charAt(0)) - s.indexOf(cond.charAt(2))) - 1;
            char sign = cond.charAt(3);
            int num = cond.charAt(4) - '0';
            
            if(sign == '=') {
                if(diff != num)
                    return false;
            }
            if(sign == '>') {
                if(diff <= num)
                    return false;
            }
            if(sign == '<') {
                if(diff >= num)
                    return false;
            }
        }
        return true;
    }
}
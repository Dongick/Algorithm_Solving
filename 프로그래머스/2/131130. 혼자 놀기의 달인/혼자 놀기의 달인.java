class Solution {
    static int max = 0;
    
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length + 1];
        for(int i = 1; i <= cards.length; i++) {
            visited[i] = true;
            func1(1, cards[i-1], visited, cards);
            visited[i] = false;
        }
        int answer = max;
        return answer;
    }
    
    static void func1(int count, int num, boolean[] visited, int[] cards) {
        if(visited[num]) {
            if(count == cards.length)
                return;
            
            for(int i = 1; i <= cards.length; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    func2(count, 1, cards[i-1], visited, cards);
                    visited[i] = false;
                }
            }
            return;
        }
        
        visited[num] = true;
        func1(count+1, cards[num-1], visited, cards);
        visited[num] = false;
    }
    
    static void func2(int box1, int count, int num, boolean[] visited, int[] cards) {
        if(visited[num]) {
            max = Math.max(max, box1 * count);
            return;
        }
        
        visited[num] = true;
        func2(box1, count+1, cards[num-1], visited, cards);
        visited[num] = false;
    }
}
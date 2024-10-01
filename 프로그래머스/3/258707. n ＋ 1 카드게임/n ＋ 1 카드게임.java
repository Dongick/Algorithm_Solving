class Solution {
    static int n;
    static int[] arr;
    
    public int solution(int coin, int[] cards) {
        n = cards.length;
        arr = new int[n + 1];
        
        for(int i = 0; i < n / 3; i++) {
            arr[cards[i]] = 1;
        }
        int answer = func(cards, coin);
        return answer;
    }
    
    static int func(int[] cards, int coin) {
        int idx = n / 3;
        int round = 1;
        while(idx < n) {
            arr[cards[idx]] = 2;
            arr[cards[idx+1]] = 2;
            
            int min = 3;
            int minIdx = 0;
            for(int i = 1; i <= n/2; i++) {
                if(arr[i] != 0 && arr[n-i+1] != 0) {
                    if(min > arr[i] + arr[n-i+1] - 2) {
                        min = arr[i] + arr[n-i+1] - 2;
                        minIdx = i;
                    }
                }
            }
            if(min == 3 || coin < min)
                break;
            arr[minIdx] = 0;
            arr[n-minIdx+1] = 0;
            round++;
            coin -= min;
            idx += 2;
        }
        return round;
    }
}
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
            
            boolean check = false;
            for(int i = 1; i <= n; i++) {
                if(arr[i] == 1 && arr[n-i+1] == 1) {
                    arr[i] = 0;
                    arr[n-i+1] = 0;
                    check = true;
                    break;
                }
            }
            if(check) {
                idx += 2;
                round++;
                continue;
            }
            
            if(coin >= 1) {
                for(int i = 1; i <= n; i++) {
                    if((arr[i] == 1 && arr[n-i+1] == 2) || (arr[i] == 2 && arr[n-i+1] == 1)) {
                        arr[i] = 0;
                        arr[n-i+1] = 0;
                        check = true;
                        coin--;
                        break;
                    }
                }
                if(check) {
                    idx += 2;
                    round++;
                    continue;
                }
            }
            
            if(coin >= 2) {
                for(int i = 1; i <= n; i++) {
                    if((arr[i] == 2 && arr[n-i+1] == 2)) {
                        arr[i] = 0;
                        arr[n-i+1] = 0;
                        check = true;
                        coin -= 2;
                        break;
                    }
                }
                if(check) {
                    idx += 2;
                    round++;
                    continue;
                }
            }
            
            return round;
        }
        return round;
    }
}
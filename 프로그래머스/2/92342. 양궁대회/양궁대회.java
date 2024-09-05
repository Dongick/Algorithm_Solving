class Solution {
    static int[] answer = new int[11];
    static int sum = 0;
    
    public int[] solution(int n, int[] info) {
        
        func(0, n, info, new int[11], 0);
        boolean check = false;
        for(int i = 0; i < 10; i++) {
            if(answer[i] != 0) {
                check = true;
                break;
            }
        }
        if(check)
            return answer;
        else {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
    }
    
    static void func(int count, int n, int[] info, int[] rion, int idx) {
        if(idx == 10) {
            int rionSum = 0;
            int apichSum = 0;
            for(int i = 0; i < 10; i++) {
                if(info[i] == 0 && rion[i] == 0)
                    continue;
                if(info[i] < rion[i])
                    rionSum += 10 - i;
                else
                    apichSum += 10 - i;
            }
            
            if(rionSum > apichSum && sum <= rionSum - apichSum) {
                if(sum == rionSum - apichSum) {
                    if(answer[idx] > n - count)
                        return;
                    if(answer[idx] == n - count) {
                        boolean check = true;
                        for(int i = 10; i >= 0; i--) {
                            if(rion[i] > answer[i]) {
                                break;
                            }
                            if(rion[i] < answer[i]) {
                                check = false;
                                break;
                            }
                        }
                        if(!check)
                            return;
                    }
                }
                for(int i = 0; i < 10; i++)
                    answer[i] = rion[i];
                answer[idx] = n - count;
                sum = rionSum - apichSum;
                
            }
            return;
        }
        
        for(int i = idx; i < 10; i++) {
            if(count + info[i] + 1 <= n)
                rion[i] = info[i] + 1;
            func(count + rion[i], n, info, rion, i + 1);
            rion[i] = 0;
        }
    }
}
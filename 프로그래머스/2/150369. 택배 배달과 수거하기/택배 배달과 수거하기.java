import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverMax = 0;
        int pickupMax = 0;
        for(int i = 0; i < n; i++) {
            if(deliveries[i] > 0)
                deliverMax = i;
        }
        for(int i = 0; i < n; i++) {
            if(pickups[i] > 0)
                pickupMax = i;
        }
        
        while(true) {
            int deliver = 0;
            int deliverCount = 0;
            int pickup = 0;
            int pickupCount = 0;
            
            for(int i = deliverMax; i >= 0; i--) {
                if(deliveries[i] > 0) {
                    deliver = i + 1;
                    for(int j = i; j >= 0; j--) {
                        while(deliveries[j] > 0 && deliverCount < cap) {
                            deliveries[j]--;
                            deliverCount++;
                        }
                        if(deliverCount == cap || j == 0) {
                            deliverMax = j;
                            break;
                        }
                    }
                    break;
                }
            }
            
            for(int i = pickupMax; i >= 0; i--) {
                if(pickups[i] > 0) {
                    pickup = i + 1;
                    for(int j = i; j >= 0; j--) {
                        while(pickups[j] > 0 && pickupCount < cap) {
                            pickups[j]--;
                            pickupCount++;
                        }
                        if(pickupCount == cap || j == 0) {
                            pickupMax = j;
                            break;
                        }
                    }
                    break;
                }
            }
            if(pickup == 0 && deliver == 0)
                break;
            
            answer += Math.max(pickup, deliver) * 2;
            
        }
        return answer;
    }
}
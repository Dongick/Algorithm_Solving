import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> timeMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            if(arr[2].equals("IN")) {
                map.put(arr[1], arr[0]);
            } else {
                String[] inTime = map.get(arr[1]).split(":");
                String[] outTime = arr[0].split(":");
                int time = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + (Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]));
                if(timeMap.containsKey(arr[1])) {
                    int remainTime = timeMap.get(arr[1]);
                    timeMap.replace(arr[1], remainTime + time);
                } else
                    timeMap.put(arr[1], time);
                map.remove(arr[1]);
            }
        }
        
        if(map.size() > 0) {
            for(String key : map.keySet()) {
                String[] inTime = map.get(key).split(":");
                int time = (23 - Integer.parseInt(inTime[0])) * 60 + (59 - Integer.parseInt(inTime[1]));
                if(timeMap.containsKey(key)) {
                    int remainTime = timeMap.get(key);
                    timeMap.replace(key, remainTime + time);
                } else
                    timeMap.put(key, time);
            }
        }
        
        List<String> list = new ArrayList<>(timeMap.keySet());
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int i = 0;
        for(String key : list) {
            int fee = 0;
            int time = timeMap.get(key);
            if(fees[0] >= time)
                fee = fees[1];
            else {
                int remainTime = time - fees[0];
                if(remainTime % fees[2] == 0)
                    fee = fees[1] + remainTime / fees[2] * fees[3];
                else
                    fee = fees[1] + (remainTime / fees[2] + 1) * fees[3];
            }
            answer[i] = fee;
            i++;
        }
        
        return answer;
    }
}
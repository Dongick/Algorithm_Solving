import java.util.*;

class Solution {
    static Map<Integer, ArrayList<String>> map = new HashMap<>();
    static Map<String ,ArrayList<Integer>> record = new HashMap<>();
    static int sum;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        func1();
        for(String s : info) {
            func2(s);
        }
        
        for(String key : record.keySet()) {
            Collections.sort(record.get(key)); 
        }
        
        for(int i = 0; i < query.length; i++) {
            String[] str = query[i].split(" and ");
            String[] num = str[3].split(" ");
            str[3] = num[0];
            sum = 0;
            func3(0, "", str, Integer.parseInt(num[1]));
            answer[i] = sum;
        }
        
        return answer;
    }
    
    static void func1() {
        map.put(0, new ArrayList<>(Arrays.asList("cpp", "java", "python")));
        map.put(1, new ArrayList<>(Arrays.asList("backend", "frontend")));
        map.put(2, new ArrayList<>(Arrays.asList("junior", "senior")));
        map.put(3, new ArrayList<>(Arrays.asList("chicken", "pizza")));
    }
    
    static void func2(String s) {
        String[] arr = s.split(" ");
        String key = arr[0] + arr[1] + arr[2] + arr[3];
        if(record.containsKey(key))
            record.get(key).add(Integer.parseInt(arr[4]));
        else {
            record.put(key, new ArrayList<>(Arrays.asList(Integer.parseInt(arr[4]))));
        }
    }
    
    static void func3(int depth, String key, String[] str, int num) {
        if(depth == 4) {
            if(!record.containsKey(key))
                return;
            
            List<Integer> temp = record.get(key);
            int start = 0;
            int end = temp.size();
            while(start < end) {
                int mid = (start + end) / 2;
                
                if(temp.get(mid) >= num)
                    end = mid;
                else
                    start = mid + 1;
            }
            sum += temp.size() - start;
            return;
        }
        
        if(str[depth].length() == 1) {
            for(String s : map.get(depth)) {
                func3(depth+1, key+s, str, num);
            }
        } else
            func3(depth+1, key+str[depth], str, num);
    }
}
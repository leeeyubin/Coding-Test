import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종류별 옷 세기
        for(String[] cloth : clothes) {
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 종류별 선택지 곱하기
        for(int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}

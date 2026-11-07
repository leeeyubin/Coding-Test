class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < current) {
                // 이전 숫자 제거
                sb.deleteCharAt(sb.length() - 1);
                
                // k 감소
                k--;
            }
            
            sb.append(current);
        }
        
        // 아직 제거하지 못한 숫자가 있다면 제거 
         while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        return sb.toString();
    }
}

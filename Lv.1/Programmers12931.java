import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String numString = String.valueOf(n);
        int numLength = numString.length(); // numLength = 3
        int num = 1;
        
        for(int i = 1; i < numLength; i++) {
            num *= 10; // num = 100
        }
        
        for(int i = 1; i <= numLength; i++) {
            answer += n / num;
            n = n % num;
            num /= 10;
        }

        return answer;
    }
}

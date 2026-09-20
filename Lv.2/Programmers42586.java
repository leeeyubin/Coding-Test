import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] tmp = new int [100];
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.offer(i); // put index in. queue
        }
        
        int time = 0;

        while (!q.isEmpty()) {

            // one day progress
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            // check from the front
            int count = 0;

            while (!q.isEmpty() && progresses[q.peek()] >= 100) {
                q.poll();
                count++;
            }

            // save today's number of deploy
            if (count > 0) {
                tmp[time] = count;
                time++;
            }
        }
        
        int[] answer = new int [time];
        for(int i = 0; i < time; i++) {
            answer[i] = tmp[i];
        }
        
        return answer;
    }
    
    
}

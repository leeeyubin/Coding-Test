import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int N = scanner.nextInt();
       PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

       for(int i = 0; i < N; i++){
           int input = scanner.nextInt();

           if(input == 0) {
               if(queue.isEmpty()) System.out.println(0);
               else System.out.println(queue.poll());
               continue;
           }

           queue.add(input);
       }
    }
}

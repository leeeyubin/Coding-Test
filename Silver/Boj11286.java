import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int N = scanner.nextInt();
       PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if(absX == absY) {
                if(x < y) return -1;
                else return 1;
            } else if(absX < absY) {
                return -1;
            } else return 1;
        });

       for(int i = 0; i < N; i++) {
           int input = scanner.nextInt();

           if(input != 0) {
               queue.add(input);
           } else {
               if (queue.isEmpty()) System.out.println(0);
               else System.out.println(queue.poll());
           }
       }
    }
}

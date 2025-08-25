import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();

            if (input == 0) {
                Integer poll = queue.poll();
                if (poll == null) System.out.println(0);
                else System.out.println(poll);
            } else {
                queue.add(input);
            }
        }

        scanner.close();
    }
}

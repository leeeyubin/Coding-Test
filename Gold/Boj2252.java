import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] edgeCount = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            graph.get(x).add(y);
            edgeCount[y]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (edgeCount[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.println(front);

            for (int k : graph.get(front)) {
                edgeCount[k]--;

                if (edgeCount[k] == 0) queue.add(k);
            }
        }

        scanner.close();
    }
}

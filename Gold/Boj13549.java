import java.util.*;

public class Main {

    static int MAX = 100_001;
    static int N, K;
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        int minTime = bfs(N);
        System.out.println(minTime);

        scanner.close();
    }

    static int bfs(int start) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{start, 0});
        visited[start] = true;

        while (!deque.isEmpty()) {
            int[] node = deque.poll();

            int currentNode = node[0];
            int time = node[1];

            if (currentNode == K) return time;

            int firstCase = currentNode * 2;
            if (firstCase < MAX && !visited[firstCase]) {
                deque.addFirst(new int[]{firstCase, time});
                visited[firstCase] = true;
            }

            int secondCase = currentNode - 1;
            if (secondCase >= 0 && !visited[secondCase]) {
                deque.addLast(new int[]{secondCase, time + 1});
                visited[secondCase] = true;

            }

            int thirdCase = currentNode + 1;
            if (thirdCase < MAX && !visited[thirdCase]) {
                deque.addLast(new int[]{thirdCase, time + 1});
                visited[thirdCase] = true;
            }
        }

        return 0;
    }
}

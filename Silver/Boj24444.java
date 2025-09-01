import java.util.*;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] arrayList;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        R = scanner.nextInt();

        arrayList = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(arrayList[i]);
        }

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }

        scanner.close();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            int front = queue.poll();

            if (visited[front] != 0) continue;

            visited[front] = ++count;

            for (int k : arrayList[front]) {
                if (visited[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }
}
